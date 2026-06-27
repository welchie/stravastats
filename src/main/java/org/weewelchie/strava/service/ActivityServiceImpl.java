package org.weewelchie.strava.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.weewelchie.strava.data.beans.StravaActivity;
import org.weewelchie.strava.data.entities.Activity;
import org.weewelchie.strava.data.jpa.ActivityJpaRepository;
import org.weewelchie.strava.data.jpa.AthleteJpaRepository;

import java.util.List;
import java.util.Optional;


@Service
public class ActivityServiceImpl implements ActivityService {

    private final ModelMapper mapper;

    private final ActivityJpaRepository activityJpaRepository;

    public ActivityServiceImpl(ActivityJpaRepository repo)
    {
        this.activityJpaRepository = repo;
        this.mapper = new ModelMapper();
    }
    @Override
    public void save(Activity a) {
        activityJpaRepository.save(a);
    }

    @Override
    public Optional<Activity> getById(Long id) {
        return activityJpaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        activityJpaRepository.deleteById(id);
    }

    /**
     * Adds individual Activity to the DB
     * @param stravaActivity
     */
    @Override
    public void addActivity(StravaActivity stravaActivity) {
        activityJpaRepository.save(this.toDomain(stravaActivity));
    }

    /**
     * Adds a List of Activities to the DB.
     * @param activities
     */
    @Override
    @Transactional
    public void addActivities(List<StravaActivity> activities)
    {
        for(StravaActivity activity: activities)
        {
            activityJpaRepository.save(this.toDomain(activity));
        }

    }
    @Override
    public StravaActivity toDTO(Activity a) {
        return mapper.map(a,StravaActivity.class);
    }

    @Override
    public Activity toDomain(StravaActivity a) {
        return mapper.map(a,Activity.class);
    }
}
