package org.weewelchie.strava.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@JsonIgnoreProperties
@ToString
public class StravaDetailedActivity extends StravaActivity{

    @JsonProperty("description")
    private String description;

    @JsonProperty("calories")
    private String calories;

    @JsonProperty("perceived_exertion")
    private String perceivedExertion;

    @JsonProperty("segment_efforts")
    private List<StravaSegmentEffort> segmentEfforts;

    @JsonProperty("splits_metric")
    private List<StravaSplit> splitsMetric;

    @JsonProperty("splits_standard")
    private List<StravaSplit> splitsStandard;

    @JsonProperty("laps")
    private List<StravaLap> laps;

    @JsonProperty("best_efforts")
    private List<StravaEffort> bestEfforts;

    @JsonProperty("gear")
    private StravaGear gear;

    @JsonProperty("photos")
    private StravaPhotos photos;

    @JsonProperty("stats_visibility")
    private List<StravaStatVisibility> statsVisibility;

    @JsonProperty("hide_from_home")
    private String hideFromHome;

    @JsonProperty("device_name")
    private String deviceName;

    @JsonProperty("embed_token")
    private String embedToken;

    @JsonProperty("similar_activities")
    private StravaSimilarActivities similarActivities;

    @JsonProperty("available_zones")
    private String[] availableZones;
}
