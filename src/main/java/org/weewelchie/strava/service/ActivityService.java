package org.weewelchie.strava.service;

import org.weewelchie.strava.data.beans.StravaActivity;
import org.weewelchie.strava.data.beans.StravaAthlete;
import org.weewelchie.strava.data.entities.Activity;
import org.weewelchie.strava.data.entities.Athlete;

import java.util.List;
import java.util.Optional;

public interface ActivityService  {

    public void save(Activity a);


    public Optional<Activity> getById(Long id);

    public void delete(Long id);

    public void addActivity(StravaActivity stravaActivity);

    public void addActivities(List<StravaActivity> activities);

    public StravaActivity toDTO(Activity a);

    public Activity toDomain(StravaActivity a);
}
