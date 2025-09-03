package org.weewelchie.strava.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class StravaTrend {

    @JsonProperty("speeds")
    private List<Double> speeds;

    @JsonProperty("current_activity_index")
    private String currentActivityIndex;

    @JsonProperty("min_speed")
    private Double minSpeed;

    @JsonProperty("mid_speed")
    private Double midSpeed;

    @JsonProperty("max_speed")
    private Double maxSpeed;

    @JsonProperty("direction")
    private String direction;
}
