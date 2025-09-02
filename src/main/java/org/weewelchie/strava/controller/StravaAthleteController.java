package org.weewelchie.strava.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;
import org.weewelchie.strava.beans.StravaActivity;
import org.weewelchie.strava.beans.StravaAthlete;
import org.weewelchie.strava.beans.StravaAthleteStats;
import org.weewelchie.strava.client.StravaRestClient;
import org.weewelchie.strava.config.StravaConfigProperties;

import java.io.IOException;
import java.util.List;

@RestController
@Setter
@Getter
public class StravaAthleteController {

    private StravaRestClient restClient;

    StravaAthleteController(StravaRestClient stravaRestClient)
    {
        this.setRestClient(stravaRestClient);
    }
    @GetMapping("/athlete")
    public StravaAthlete getStavaAthlete() {
        return this.restClient.getAthleteByAccessToken();
    }

    @GetMapping("/athlete/stats")
    public StravaAthleteStats getAthleteStats() throws JsonProcessingException {
        return restClient.getAthleteStats();
    }

    @GetMapping("/athlete/activities")
    public List<StravaActivity> getAthleteActivities(@RequestParam(name = "numActivities") String numActivities) throws JsonProcessingException, IOException {

        return restClient.getAthleteActivities(numActivities);
    }


}
