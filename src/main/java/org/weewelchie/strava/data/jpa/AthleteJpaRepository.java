package org.weewelchie.strava.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.weewelchie.strava.data.entities.Athlete;

@Repository
public interface AthleteJpaRepository extends JpaRepository<Athlete, Long> {

}
