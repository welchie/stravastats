package org.weewelchie.strava.service;

import org.weewelchie.strava.data.beans.StravaAthlete;
import org.weewelchie.strava.data.beans.StravaAthleteStats;
import org.weewelchie.strava.data.entities.Athlete;
import org.weewelchie.strava.data.entities.AthleteStats;

import java.util.Optional;

public interface AthleteStatsService {

    public void save(AthleteStats a);

    public Optional<AthleteStats> getById(Long id);

    public void delete(Long id);

    public void addAthleteStats(StravaAthleteStats stravaAthleteStats, Long athleteID);

    public StravaAthleteStats toDTO(Optional<AthleteStats> a);

    public AthleteStats toDomain(Optional<StravaAthleteStats> stravaAthleteStats);
}
