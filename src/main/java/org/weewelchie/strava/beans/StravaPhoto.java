package org.weewelchie.strava.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StravaPhoto {

    @JsonProperty("unique_id")
    private String uniqueId;

    @JsonProperty("urls")
    private StravaUrl urls;

    @JsonProperty("source")
    private String source;

    @JsonProperty("mediaType")
    private String mediaType;
}
