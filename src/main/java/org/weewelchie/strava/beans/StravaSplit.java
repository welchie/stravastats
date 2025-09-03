package org.weewelchie.strava.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class StravaSplit {

    @JsonProperty("distance")
    private Double distance;

    @JsonProperty("elapsed_time")
    private String elapsedTime;

    @JsonProperty("elevation_difference")
    private String elevationDifference;

    @JsonProperty("moving_time")
    private String movingTime;

    @JsonProperty("split")
    private String split;

    @JsonProperty("average_speed")
    private Double averageSpeed;

    @JsonProperty("average_grade_adjusted_speed")
    private Double averageGradeAdjustedSpeed;

    @JsonProperty("average_heartrate")
    private Double averageHeartrate;

}
