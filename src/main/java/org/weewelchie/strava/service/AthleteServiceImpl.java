package org.weewelchie.strava.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.weewelchie.strava.data.beans.StravaAthlete;
import org.weewelchie.strava.data.entities.Athlete;
import org.weewelchie.strava.data.jpa.AthleteJpaRepository;

import java.util.Optional;

@Service
public class AthleteServiceImpl implements  AthleteService{

   private final ModelMapper mapper;

    private final AthleteJpaRepository athleteJpaRepository;
    public AthleteServiceImpl(AthleteJpaRepository repo)
    {
        this.athleteJpaRepository = repo;
        this.mapper = new ModelMapper();
    }

    @Override
    public void save(Athlete a) {
        athleteJpaRepository.save(a);
    }

    @Override
    public Optional<Athlete> getById(Long id) {
        return athleteJpaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        athleteJpaRepository.deleteById(id);
    }

    public void addAthlete(StravaAthlete stravaAthlete)
    {
        Athlete a = this.mapper.map(stravaAthlete,Athlete.class);
        athleteJpaRepository.save(a);

        //check that Athlete has been persisted
        Optional<Athlete> athlete = athleteJpaRepository.findById(stravaAthlete.getId());
    }

    @Override
    public StravaAthlete toDTO(Optional<Athlete> a) {
        return mapper.map(a, StravaAthlete.class);
    }

    @Override
    public Athlete toDomain(Optional<StravaAthlete> a) {
        return mapper.map(a,Athlete.class);
    }
}
