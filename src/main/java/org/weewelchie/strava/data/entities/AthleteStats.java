package org.weewelchie.strava.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.weewelchie.strava.data.beans.StravaStatTotals;

@Entity(name = "athlete_stats")
@Setter
@Getter
@ToString
public class AthleteStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="athlete_stats_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "athlete_id", referencedColumnName = "id")
    private Athlete athlete;

    @Column(name="biggest_ride_distance")
    private Double biggestRideDistance;

    @Column(name="biggest_climb_elevation")
    private Double biggestClimBElevation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recent_ride_totals_id")
    private AthleteStatsTotals recentRideTotals;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "all_ride_totals_id")
    private AthleteStatsTotals allRideTotals;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recent_run_totals_id")
    private AthleteStatsTotals recentRunTotals;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "all_run_totals_id")
    private AthleteStatsTotals allRunTotals;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recent_swim_totals_id")
    private AthleteStatsTotals recentSwimTotals;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "all_swim_totals_id")
    private AthleteStatsTotals allSwimTotals;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ytd_ride_totals_id")
    private AthleteStatsTotals ytdRideTotals;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ytd_run_totals_id")
    private AthleteStatsTotals ytdRunTotals;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ytd_swim_totals_id")
    private AthleteStatsTotals ytdSwimTotals;
}
