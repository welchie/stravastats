package org.weewelchie.strava.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.weewelchie.strava.beans.StravaActivity;
import org.weewelchie.strava.beans.StravaAthlete;
import org.weewelchie.strava.beans.StravaAthleteStats;
import org.weewelchie.strava.beans.StravaDetailedActivity;
import org.weewelchie.strava.client.StravaRestClient;

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
    public StravaAthlete getStravaAthlete() {
        return this.restClient.getAthleteByAccessToken();
    }

    @GetMapping("/athlete/stats")
    public StravaAthleteStats getAthleteStats() throws JsonProcessingException {
        return restClient.getAthleteStats();
    }

    @GetMapping("/athlete/activities")
    public List<StravaActivity> getAthleteActivities(@RequestParam(name = "numActivities") String numActivities) throws IOException {

        return restClient.getAthleteActivities(numActivities);
    }

    @GetMapping("/athlete/activity/{ACTIVITY_ID}")
    public StravaDetailedActivity getAthleteDetailedActivity(@PathVariable(name = "ACTIVITY_ID") String activityID) throws IOException {

        return restClient.getDetailedActivity(activityID);
    }


}
