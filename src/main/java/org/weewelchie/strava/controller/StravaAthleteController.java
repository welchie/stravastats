package org.weewelchie.strava.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.weewelchie.strava.client.StravaRestClient;
import org.weewelchie.strava.data.beans.StravaActivity;
import org.weewelchie.strava.data.beans.StravaAthlete;
import org.weewelchie.strava.data.beans.StravaAthleteStats;
import org.weewelchie.strava.data.beans.StravaDetailedActivity;
import org.weewelchie.strava.data.entities.Athlete;
import org.weewelchie.strava.service.AthleteService;
import org.weewelchie.strava.service.AthleteStatsService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@Setter
@Getter
public class StravaAthleteController {


    private StravaRestClient restClient;
    private AthleteService athleteService;
    private AthleteStatsService athleteStatsService;

    StravaAthleteController(StravaRestClient stravaRestClient, AthleteService athleteService, AthleteStatsService athleteStatsService)
    {
        this.setRestClient(stravaRestClient);
        this.setAthleteService(athleteService);
        this.setAthleteStatsService(athleteStatsService);
    }
    @GetMapping("/athlete")
    public ResponseEntity<StravaAthlete> getStravaAthlete() {
        StravaAthlete stravaAthlete = this.restClient.getAthleteByAccessToken();
        if (stravaAthlete == null) {
            return ResponseEntity.notFound().build();
        }

        //Store in the Db
        athleteService.addAthlete(stravaAthlete);

        return ResponseEntity.ok(stravaAthlete);
    }

    @GetMapping("/athlete/{id}")
    public ResponseEntity<StravaAthlete> getStravaAthleteByID(@PathVariable("id") Long id) {
        Optional<Athlete> a = athleteService.getById(id);
        if (a.isPresent()) {
            return ResponseEntity.ok(athleteService.toDTO(a));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/athlete/stats")
    public StravaAthleteStats getAthleteStats()
    {
        StravaAthlete stravaAthlete = this.restClient.getAthleteByAccessToken();
        // Save the athlete to the DB first to prevent Athlete Not Found runtime exception
        athleteService.addAthlete(stravaAthlete);

        StravaAthleteStats stravaAthleteStats= this.restClient.getAthleteStats();

        //Store in the Db
        athleteStatsService.addAthleteStats(stravaAthleteStats, stravaAthlete.getId());

        return stravaAthleteStats;
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
