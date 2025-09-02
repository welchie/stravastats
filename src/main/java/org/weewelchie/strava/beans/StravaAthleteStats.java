package org.weewelchie.strava.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties
public class StravaAthleteStats {

    @JsonProperty("biggest_ride_distance")
    private Double biggestRideDistance;

    @JsonProperty("biggest_climb_elevation")
    private Double biggestClimBElevation;

    @JsonProperty("recent_ride_totals")
    private StravaStatTotals recentRideTotals;

    @JsonProperty("all_ride_totals")
    private StravaStatTotals allRideTotals;

    @JsonProperty("recent_run_totals")
    private StravaStatTotals recentRunTotals;

    @JsonProperty("all_run_totals")
    private StravaStatTotals allRunTotals;

    @JsonProperty("recent_swim_totals")
    private StravaStatTotals recentSwimTotals;

    @JsonProperty("all_swim_totals")
    private StravaStatTotals allSwimTotals;

    @JsonProperty("ytd_ride_totals")
    private StravaStatTotals ytdRideTotals;

    @JsonProperty("ytd_run_totals")
    private StravaStatTotals ytdRunTotals;

    @JsonProperty("ytd_swim_totals")
    private StravaStatTotals ytdSwimTotals;

}
