package org.weewelchie.strava;

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
import org.weewelchie.strava.beans.StravaAthlete;
import org.weewelchie.strava.client.StravaRestClient;
import org.weewelchie.strava.controller.StravaAthleteController;

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

    @Test
    public void getAthlete() throws Exception {
        mockMvc.perform(get("/athlete").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void getAthleteDetails() throws Exception {
         mockMvc.perform(get("/athlete")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(stravaAthlete)))
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
        mockMvc.perform(get("/athlete/stats")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(stravaAthlete)))
                .andExpect(status().isOk());
    }

    @Test
    public void getAthleteActivities() throws Exception {
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
        MvcResult result= mockMvc.perform(get("/athlete/activity/{ACTIVITY_ID", 99)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(stravaAthlete)))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getAthleteDetailedActivity_Null_ID() throws Exception {
        mockMvc.perform(get("/athlete/activity/{ACTIVITY_ID}", (Object) null)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(stravaAthlete)))
                .andExpect(status().isNotFound());
    }


//     @GetMapping("/athlete/activity/{ACTIVITY_ID}")
//    public StravaDetailedActivity getAthleteDetailedActivity(@PathVariable(name = "ACTIVITY_ID") String activityID) throws IOException {


    }
