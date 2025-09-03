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


    /*


    "hide_from_home": false,
    "device_name": "Garmin Forerunner 235",
    "embed_token": "9bc3977b809257e4f0b9a2e28bd35d50a7c09c8a",
    "similar_activities": {
        "effort_count": 88,
        "average_speed": 3.0528257491780657,
        "min_average_speed": 2.779524584800201,
        "mid_average_speed": 3.100733826513,
        "max_average_speed": 3.50588297223513,
        "pr_rank": null,
        "frequency_milestone": null,
        "trend": {
            "speeds": [
                3.086985259128194,
                3.0875308941307247,
                3.050339104903966,
                3.051473657614121,
                3.0154740156410833
            ],
            "current_activity_index": 3,
            "min_speed": 2.779524584800201,
            "mid_speed": 3.100733826513,
            "max_speed": 3.50588297223513,
            "direction": 0
        },
        "resource_state": 2
    },
    "available_zones": []
}
     */

}
