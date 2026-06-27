package org.weewelchie.strava.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.weewelchie.strava.client.StravaRestClient;
import org.weewelchie.strava.data.beans.StravaAthlete;
import org.weewelchie.strava.data.beans.StravaAthleteStats;
import org.weewelchie.strava.data.entities.Athlete;
import org.weewelchie.strava.service.AthleteService;
import org.weewelchie.strava.service.AthleteStatsService;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest (controllers = StravaAthleteController.class)

public class StravaAthleteControllerTest {

    private static Logger log = LoggerFactory.getLogger("StravaAthleteControllerTest");

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

   @MockitoBean
   private StravaRestClient stravaRestClient;

   @MockitoBean
    private StravaAthlete stravaAthlete;

   @MockitoBean
   private AthleteService athleteService;

   @MockitoBean
   private AthleteStatsService athleteStatsService;

    @Test
    public void getAthlete() throws Exception {
        when(stravaRestClient.getAthleteByAccessToken()).thenReturn(new StravaAthlete());
        mockMvc.perform(get("/athlete").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void getAthleteById() throws Exception {
        when(athleteService.getById(1234567890L)).thenReturn(Optional.of(new Athlete()));
        mockMvc.perform(get("/athlete/{id}","1234567890").
                contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    public void invalidURL() throws Exception {
        mockMvc.perform(get("/test")
                        .contentType(MediaType.APPLICATION_JSON)
                        )
                .andExpect(status().isNotFound());
    }

    @Test
    public void getAthleteStats() throws Exception {
        StravaAthlete athlete = new StravaAthlete();
        athlete.setId(12345L);
        when(stravaRestClient.getAthleteByAccessToken()).thenReturn(athlete);
        when(stravaRestClient.getAthleteStats()).thenReturn(new StravaAthleteStats());

        mockMvc.perform(get("/athlete/stats")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getAthleteActivities() throws Exception {
        when(stravaRestClient.getAthleteActivities("99")).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/athlete/activities")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("numActivities","99"))
                .andExpect(status().isOk());
    }

    @Test
    public void getAthleteActivities_NoParam() throws Exception {
        mockMvc.perform(get("/athlete/activities")
                        .contentType(MediaType.APPLICATION_JSON)
                        )
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getAthleteDetailedActivity() throws Exception {
        MvcResult result= mockMvc.perform(get("/athlete/activity/{ACTIVITY_ID}", 99)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getAthleteDetailedActivity_Null_ID() throws Exception {
        mockMvc.perform(get("/athlete/activity/{ACTIVITY_ID}", (Object) null)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    }
