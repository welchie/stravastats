package org.weewelchie.strava.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class StravaSegmentActivity {

    @JsonProperty("id")
    private String id;

    @JsonProperty("visibility")
    private String visibility;

    @JsonProperty("resource_state")
    private String resourceState;

}
