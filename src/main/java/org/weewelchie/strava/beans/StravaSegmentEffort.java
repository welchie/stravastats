package org.weewelchie.strava.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class StravaSegmentEffort {


    @JsonProperty("id")
    private String id;

    @JsonProperty("resource_state")
    private String resourceState;

    @JsonProperty("name")
    private String name;

    @JsonProperty("activity")
    private StravaSegmentActivity activity;

    @JsonProperty("athlete")
    private StravaAthleteShort athlete;

    @JsonProperty("elapsed_time")
    private String elapsedTime;

    @JsonProperty("moving_time")
    private String movingTime;

    @JsonProperty("start_date")
    private String startDate;

    @JsonProperty("start_date_local")
    private String startDateLocal;

    @JsonProperty("distance")
    private String distance;

    @JsonProperty("start_index")
    private String startIndex;

    @JsonProperty("end_index")
    private String endIndex;

    @JsonProperty("average_cadence")
    private String averageCadence;

    @JsonProperty("device_watts")
    private String deviceWatts;

    @JsonProperty("average_heartrate")
    private String averageHeartrate;

    @JsonProperty("max_heartrate")
    private String maxHeartrate;

    @JsonProperty("segment")
    private StravaSegment segment;

    @JsonProperty("pr_rank")
    private String prRank;

    @JsonProperty("achievements")
    private List<StravaAchievement> achievements;

    @JsonProperty("visibility")
    private String visibility;

    @JsonProperty("hidden")
    private Boolean hidden;
}
