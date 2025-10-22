package org.weewelchie.strava.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.weewelchie.strava.client.StravaRestClient;

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



    private StravaRestClient stravaRestClient;

    @Bean
    public StravaRestClient getStravaRestClient() {
        return stravaRestClient;
    }


}
