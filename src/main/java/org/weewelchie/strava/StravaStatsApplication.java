package org.weewelchie.strava;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StravaStatsApplication {

    private static final Logger log = LoggerFactory.getLogger(StravaStatsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StravaStatsApplication.class, args);
	}
}
