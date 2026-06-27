package org.weewelchie.strava.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.weewelchie.strava.data.entities.AthleteStatsTotals;

public interface AthleteStatsTotalsRepository extends JpaRepository<AthleteStatsTotals,Long> {
}
