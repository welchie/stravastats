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
public class StravaActivityShort {

    @JsonProperty("resource_state")
    private String resourceState;

    @JsonProperty("id")
    private String id;
}
