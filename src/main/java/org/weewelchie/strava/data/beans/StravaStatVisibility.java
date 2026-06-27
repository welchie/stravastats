package org.weewelchie.strava.data.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StravaStatVisibility {

    @JsonProperty("type")
    private String type;

    @JsonProperty("visibility")
    private String visibility;
}
