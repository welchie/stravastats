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
public class StravaAthleteShort {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("resource_state")
    private String resourceState;
}
