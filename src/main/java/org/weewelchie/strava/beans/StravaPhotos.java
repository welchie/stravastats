package org.weewelchie.strava.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StravaPhotos {

    @JsonProperty("primary")
    private StravaPhoto primaryPhoto;

    @JsonProperty("use_primary_photo")
    private Boolean usePrimaryPhoto;

    @JsonProperty("count")
    private String count;
}
