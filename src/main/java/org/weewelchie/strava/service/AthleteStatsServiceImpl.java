package org.weewelchie.strava.service;

import org.hibernate.annotations.NotFound;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.weewelchie.strava.data.beans.StravaAthleteStats;
import org.weewelchie.strava.data.entities.Athlete;
import org.weewelchie.strava.data.entities.AthleteStats;
import org.weewelchie.strava.data.jpa.AthleteStatsJpaRepository;
import org.weewelchie.strava.data.jpa.AthleteStatsTotalsRepository;

import java.util.Optional;

@Service
public class AthleteStatsServiceImpl implements AthleteStatsService{

    private final ModelMapper mapper;

    private final AthleteStatsJpaRepository athleteStatsJpaRepository;

    private final AthleteStatsTotalsRepository athleteStatsTotalsRepository;

    private final AthleteService athleteService;
    public AthleteStatsServiceImpl(AthleteStatsJpaRepository athleteStatsJpaRepository, AthleteStatsTotalsRepository athleteStatsTotalsRepository, AthleteService athleteService)
    {
        this.athleteStatsJpaRepository = athleteStatsJpaRepository;
        this.athleteStatsTotalsRepository = athleteStatsTotalsRepository;
        this.athleteService = athleteService;
        this.mapper = new ModelMapper();
    }
    @Override
    public void save(AthleteStats athleteStats) {
        athleteStatsJpaRepository.save(athleteStats);
    }

    @Override
    public Optional<AthleteStats> getById(Long id) {
        return athleteStatsJpaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        athleteStatsJpaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void addAthleteStats(StravaAthleteStats stravaAthleteStats, Long athleteID) {
        Optional<Athlete> a = athleteService.getById(athleteID);
        if (!a.isPresent()) {
            throw new RuntimeException("Athlete Not Found");
        }

        // Delete existing stats for this athlete to prevent Unique Constraint violation
        Optional<AthleteStats> existing = athleteStatsJpaRepository.findByAthleteId(athleteID);
        if (existing.isPresent()) {
            athleteStatsJpaRepository.delete(existing.get());
            athleteStatsJpaRepository.flush();
        }

        AthleteStats athleteStats = this.toDomain(Optional.ofNullable(stravaAthleteStats));
        athleteStats.setAthlete(a.get());
        athleteStatsJpaRepository.save(athleteStats);
    }

    @Override
    public StravaAthleteStats toDTO(Optional<AthleteStats> athleteStats) {
        return mapper.map(athleteStats, StravaAthleteStats.class);
    }

    @Override
    public AthleteStats toDomain(Optional<StravaAthleteStats> stravaAthleteStats) {
        return mapper.map(stravaAthleteStats, AthleteStats.class);
    }
}
