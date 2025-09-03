package org.weewelchie.strava.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StravaLap {

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
    private String startDate;

    @JsonProperty("start_date_local")
    private String startDateLocal;

    @JsonProperty("distance")
    private Double distance;

    @JsonProperty("average_speed")
    private String averageSpeed;

    @JsonProperty("max_speed")
    private String maxSpeed;

    @JsonProperty("lap_index")
    private Integer lapIndex;

    @JsonProperty("split")
    private Integer split;

    @JsonProperty("start_index")
    private Integer startIndex;

    @JsonProperty("end_index")
    private Integer endIndex;

    @JsonProperty("total_elevation_gain")
    private Double totalElevationGain;

    @JsonProperty("average_cadence")
    private Double averageCadence;

    @JsonProperty("device_watts")
    private String deviceWatts;

    @JsonProperty("average_heartrate")
    private Double averageHeartrate;

    @JsonProperty("max_heartrate")
    private Double maxHeartrate;

    @JsonProperty("pace_zone")
    private String paceZone;
}
