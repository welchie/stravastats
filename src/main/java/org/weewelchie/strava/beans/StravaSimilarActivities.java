package org.weewelchie.strava.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StravaSimilarActivities {

    @JsonProperty("effort_count")
    private String effortCount;

    @JsonProperty("average_speed")
    private Double averageSpeed;

    @JsonProperty("min_average_speed")
    private Double minAverageSpeed;

    @JsonProperty("mid_average_speed")
    private Double midAverageSpeed;

    @JsonProperty("max_average_speed")
    private Double maxAverageSpeed;

    @JsonProperty("pr_rank")
    private String prRank;

    @JsonProperty("frequency_milestone")
    private String frequencyMilestone;

    @JsonProperty("trend")
    private StravaTrend trend;

    @JsonProperty("resource_state")
    private String resourceState;

    /*
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
     */
}
