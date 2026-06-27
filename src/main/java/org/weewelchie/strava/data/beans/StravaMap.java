package org.weewelchie.strava.data.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Embeddable
@JsonIgnoreProperties
public class StravaMap
{
    @JsonProperty("id")
    private String id;

    @JsonProperty("polyline")
    private String polyline;

    @JsonProperty("summary_polyline")
    private String summary_polyline;

   // @JsonProperty("resource_state")
   // private String resourceState;
}
