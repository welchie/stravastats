package org.weewelchie.strava.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@JsonIgnoreProperties
public class StravaMap
{
    @JsonProperty("id")
    private String id;

    @JsonProperty("summary_polyline")
    private String summary_polyline;

    @JsonProperty("resource_state")
    private String resourceState;
}
