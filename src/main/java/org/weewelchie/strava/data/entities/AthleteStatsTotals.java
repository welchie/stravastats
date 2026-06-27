package org.weewelchie.strava.data.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity (name="athlete_stats_totals")
public class AthleteStatsTotals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="count")
    private Integer count;

    @Column(name="distance")
    private Double distance;

    @Column(name="moving_time")
    private Integer movingTime;

    @Column(name="elapsed_time")
    private Integer elapsedTime;

    @Column(name="elevation_gain")
    private Double elevationGain;

    @Column(name="achievement_count")
    private Integer achievementCount;

}
