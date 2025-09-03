package org.weewelchie.strava.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StravaUrl {


    @JsonProperty("600")
    private String url600;

    @JsonProperty("100")
    private String url100;

}
