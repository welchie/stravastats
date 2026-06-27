package org.weewelchie.strava.data.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.weewelchie.strava.data.entities.Activity;

@Repository
public interface ActivityJpaRepository extends JpaRepository<Activity, Long> {
}
