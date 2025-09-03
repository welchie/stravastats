package org.weewelchie.strava.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class StravaEffort {

    @JsonProperty("id")
    private String id;

    @JsonProperty("resource_state")
    private String resourceState;

    @JsonProperty("name")
    private String name;

    @JsonProperty("activity")
    private StravaActivityShort activity;

    @JsonProperty("athlete")
    private StravaAthleteShort athlete;

    @JsonProperty("elapsed_time")
    private String elapsedTime;

    @JsonProperty("moving_time")
    private String movingTime;

    @JsonProperty("start_date")
    private String starDate;

    @JsonProperty("start_date_local")
    private String startDateLocal;

    @JsonProperty("distance")
    private Double distance;

    @JsonProperty("pr_rank")
    private String prRank;

    @JsonProperty("achievements")
    private List<StravaAchievement> achievements;

    @JsonProperty("start_index")
    private String start_index;

    @JsonProperty("end_index")
    private String endIndex;
}
