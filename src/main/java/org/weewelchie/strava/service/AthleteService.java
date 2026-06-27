package org.weewelchie.strava.service;

import org.weewelchie.strava.data.beans.StravaAthlete;
import org.weewelchie.strava.data.entities.Athlete;

import java.util.Optional;

public interface AthleteService {

    public void save(Athlete a);

    public Optional<Athlete> getById(Long id);

    public void delete(Long id);

    public void addAthlete(StravaAthlete stravaAthlete);

    public StravaAthlete toDTO(Optional<Athlete> a);

    public Athlete toDomain(Optional<StravaAthlete> a);
}
