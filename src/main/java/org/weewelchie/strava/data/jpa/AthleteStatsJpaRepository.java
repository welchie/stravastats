package org.weewelchie.strava.data.jpa;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.weewelchie.strava.data.entities.AthleteStats;

@Repository
public interface AthleteStatsJpaRepository extends JpaRepository<AthleteStats, Long> {
    Optional<AthleteStats> findByAthleteId(Long athleteId);
}
