package org.weewelchie.strava.client;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.weewelchie.strava.config.StravaConfigProperties;
import org.weewelchie.strava.data.beans.*;


import java.io.IOException;
import java.util.*;

@Service
public class StravaRestClient {

    private final StravaConfigProperties stravaConfigProperties;
    private final static String GET_ATHLETE_BY_ACCESS_TOKEN = "https://www.strava.com/api/v3/athlete?access_token=";
    private final static String GET_ATHLETE_STATS = "https://www.strava.com/api/v3/athletes/{ATHLETE_ID}/stats?access_token={ACCESS_TOKEN}";
    private final static String GET_ATHLETE_ACTIVITIES = "https://www.strava.com/api/v3/athlete/activities?per_page={pages}";
    private final static String GET_DETAILED_ACTIVITY = "https://www.strava.com/api/v3/activities/{ACTIVITY_ID}?include_all_efforts=true";
    private final static String REFRESH_TOKEN_URL = "https://www.strava.com/api/v3/oauth/token?client_id={CLIENT_ID}&client_secret={CLIENT_SECRET}&grant_type=refresh_token&refresh_token={REFRESH_TOKEN}";

    private final static Double METRES_TO_MILES = 0.000621371;

    private final RestTemplate restTemplate = new RestTemplate();

    private final Logger log = LoggerFactory.getLogger(StravaRestClient.class);

    private StravaRefreshToken stravaRefreshToken;

    public StravaRestClient(StravaConfigProperties stravaConfigProperties)
    {
        log.info("Initialising StravaRestClient");
        log.info("ATHLETE_ID: " + stravaConfigProperties.getAthleteID());
        this.stravaConfigProperties = stravaConfigProperties;
    }

    private synchronized void checkAndRefreshToken() {
        if (stravaRefreshToken == null || isTokenExpired()) {
            refreshToken();
        }
    }

    private boolean isTokenExpired() {
        if (stravaRefreshToken == null) {
            return true;
        }
        long currentEpochSec = System.currentTimeMillis() / 1000;
        return stravaRefreshToken.getExpiresAt() == null || (stravaRefreshToken.getExpiresAt() - currentEpochSec) < 30;
    }

    public StravaAthlete getAthleteByAccessToken()  {
        checkAndRefreshToken();
        log.info("getting Athlete by access token");
        ResponseEntity<StravaAthlete> response
                = restTemplate.getForEntity(GET_ATHLETE_BY_ACCESS_TOKEN + stravaRefreshToken.getAccessToken(), StravaAthlete.class);

        StravaAthlete stravaAthlete = response.getBody();

        log.info("Athlete: " +  stravaAthlete);
        return stravaAthlete;
    }

    public StravaAthleteStats getAthleteStats() {
        checkAndRefreshToken();
        log.info("getting Athlete Stats");

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("ATHLETE_ID", String.valueOf(stravaConfigProperties.getAthleteID()));
        uriVariables.put("ACCESS_TOKEN", stravaRefreshToken.getAccessToken());
        ResponseEntity<StravaAthleteStats> response
                = restTemplate.getForEntity(GET_ATHLETE_STATS, StravaAthleteStats.class,uriVariables);

        StravaAthleteStats stravaAthleteStats = response.getBody();

        log.info("Athlete Stats: " +  stravaAthleteStats);
        return stravaAthleteStats;
    }

    public List<StravaActivity> getAthleteActivities(String numActivities) throws IOException {
        checkAndRefreshToken();
        log.info("getting Athlete Activities ");

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("pages", numActivities);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity<>(headers);
        headers.setBearerAuth(stravaRefreshToken.getAccessToken());

        ResponseEntity<String> response
                = restTemplate.exchange(GET_ATHLETE_ACTIVITIES, HttpMethod.GET,entity, String.class, uriVariables);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());

        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        TypeReference<List<StravaActivity>> jacksonTypeReference = new TypeReference<>() {};

        List<StravaActivity> activities = objectMapper.readValue(root.traverse(), jacksonTypeReference);

        log.info("Athlete Stats: " +  activities);

        return activities;
    }

    public StravaDetailedActivity getDetailedActivity(String activityID) {
        checkAndRefreshToken();
        log.info("getting Detailed Athlete Activity");

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("ACTIVITY_ID", activityID);

        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity<>(headers);
        headers.setBearerAuth(stravaRefreshToken.getAccessToken());

        ResponseEntity<StravaDetailedActivity> response
                = restTemplate.exchange(GET_DETAILED_ACTIVITY, HttpMethod.GET,entity, StravaDetailedActivity.class, uriVariables);

        StravaDetailedActivity stravaDetailedActivity = response.getBody();

        log.info("Athlete Detailed Activity: " +  stravaDetailedActivity);
        return stravaDetailedActivity;
    }

    public StravaRefreshToken refreshToken()
    {
        log.info("Refreshing Token ACCESS TOKEN");

        Map<String, String> map = new HashMap<>();
        map.put("CLIENT_ID", stravaConfigProperties.getClientID());
        map.put("CLIENT_SECRET", stravaConfigProperties.getClientSecret());
        map.put("REFRESH_TOKEN", stravaConfigProperties.getRefreshToken());

        StravaAccessToken objEmp = new StravaAccessToken();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<StravaAccessToken> requestEntity = new HttpEntity<>(objEmp, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<StravaRefreshToken> responseEntity = restTemplate.postForEntity(REFRESH_TOKEN_URL, requestEntity, StravaRefreshToken.class, map);

        log.info("Status Code: " + responseEntity.getStatusCode());
        stravaRefreshToken = responseEntity.getBody();
        if (stravaRefreshToken != null) {
            log.info("Token refreshed successfully");
        }

        return stravaRefreshToken;
    }

}