package org.weewelchie.strava.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class StravaSegment {

    @JsonProperty("id")
    private String id;

    @JsonProperty("resource_state")
    private String resourceState;

    @JsonProperty("name")
    private String name;

    @JsonProperty("activity_type")
    private String activityType;

    @JsonProperty("distance")
    private Double distance;

    @JsonProperty("average_grade")
    private String averageGrade;

    @JsonProperty("maximum_grade")
    private String maximumGrade;

    @JsonProperty("elevation_high")
    private String elevationHigh;

    @JsonProperty("elevation_low")
    private String elevationLow;

    @JsonProperty("start_latlng")
    private String[] startLatlng;

    @JsonProperty("end_latlng")
    private String[] endLatlng;

    @JsonProperty("elevation_profile")
    private String elevationProfile;

    @JsonProperty("elevation_profiles")
    private String elevationProfiles;

    @JsonProperty("climb_category")
    private String climbCategory;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("country")
    private String country;

    @JsonProperty("private")
    private Boolean privateSegment;

    @JsonProperty("hazardous")
    private Boolean hazardous;

    @JsonProperty("starred")
    private Boolean starred;
}
