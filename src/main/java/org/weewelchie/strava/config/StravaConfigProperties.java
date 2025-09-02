package org.weewelchie.strava.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "strava")
@ConfigurationPropertiesScan
@Setter
@Getter
public class StravaConfigProperties {
    private String refreshToken;
    private String clientID;

    private String clientSecret;

    private Integer athleteID;
}
