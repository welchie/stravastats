package org.weewelchie.strava.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class StravaAchievement {

    @JsonProperty("type_id")
    private String typeID;

    @JsonProperty("type")
    private String type;

    @JsonProperty("rank")
    private String rank;

    @JsonProperty("effort_count")
    private String effortCount;

}
