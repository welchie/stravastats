package org.weewelchie.strava.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties
public class StravaStatTotals {

    @JsonProperty("count")
    private Integer count;

    @JsonProperty("distance")
    private Double distance;

    @JsonProperty("moving_time")
    private Integer movingTime;

    @JsonProperty("elapsed_time")
    private Integer elapsedTime;

    @JsonProperty("elevation_gain")
    private Double elevationGain;

    @JsonProperty("achievement_count")
    private Integer achievementCount;

}
