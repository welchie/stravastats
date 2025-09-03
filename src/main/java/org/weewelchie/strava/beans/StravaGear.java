package org.weewelchie.strava.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class StravaGear {

    @JsonProperty("id")
    private String id;

    @JsonProperty("primary")
    private Boolean primary;

    @JsonProperty("name")
    private String name;

    @JsonProperty("nickname")
    private String mickname;

    @JsonProperty("resource_state")
    private String resource_state;

    @JsonProperty("retired")
    private Boolean retired;

    @JsonProperty("distance")
    private String distance;

    @JsonProperty("converted_distance")
    private String convertedDistance;
}
