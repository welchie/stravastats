package org.weewelchie.strava.service;

import java.util.List;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import org.weewelchie.strava.data.beans.StravaActivity;
import org.weewelchie.strava.data.beans.StravaAthleteStats;

@Service
public class GeminiService {

    private final ChatClient chatClient;

    public GeminiService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    public String getJoke(String topic) {
        return chatClient.prompt()
                .user("Tell me a joke about " + topic)
                .call()
                .content();
    }

    public String analyzeActivities(List<StravaActivity> activities) {
        StringBuilder builder = new StringBuilder();
        builder.append("Here is the training data for the athlete's recent activities:\n\n");
        for (StravaActivity activity : activities) {
            double distanceKm = activity.getDistance() != null ? activity.getDistance() / 1000.0 : 0.0;
            int movingTimeMin = activity.getMovingTime() != null ? activity.getMovingTime() / 60 : 0;
            builder.append(String.format("- Name: %s, Type: %s, Distance: %.2f km, Moving Time: %d mins, Elevation Gain: %s m, Date: %s\n",
                    activity.getName(),
                    activity.getType(),
                    distanceKm,
                    movingTimeMin,
                    activity.getTotalElevationGain(),
                    activity.getStartDateLocal()));
        }
        builder.append("\nPlease analyze this training data. Provide insights on workload, training variety, suggested rest, and performance trends.");
        
        return chatClient.prompt()
                .user(builder.toString())
                .call()
                .content();
    }

    public String analyzeStats(StravaAthleteStats stats) {
        StringBuilder builder = new StringBuilder();
        builder.append("Here are the lifetime and recent totals for the athlete:\n\n");
        double biggestRideKm = stats.getBiggestRideDistance() != null ? stats.getBiggestRideDistance() / 1000.0 : 0.0;
        builder.append(String.format("- Biggest Ride Distance: %.2f km\n", biggestRideKm));
        builder.append(String.format("- Biggest Climb Elevation: %s m\n", stats.getBiggestClimBElevation()));
        
        if (stats.getRecentRideTotals() != null) {
            double recentRideKm = stats.getRecentRideTotals().getDistance() != null ? stats.getRecentRideTotals().getDistance() / 1000.0 : 0.0;
            builder.append(String.format("- Recent Rides Count: %d, Total Distance: %.2f km, Total Elevation: %s m\n",
                    stats.getRecentRideTotals().getCount(),
                    recentRideKm,
                    stats.getRecentRideTotals().getElevationGain()));
        }
        if (stats.getRecentRunTotals() != null) {
            double recentRunKm = stats.getRecentRunTotals().getDistance() != null ? stats.getRecentRunTotals().getDistance() / 1000.0 : 0.0;
            builder.append(String.format("- Recent Runs Count: %d, Total Distance: %.2f km, Total Elevation: %s m\n",
                    stats.getRecentRunTotals().getCount(),
                    recentRunKm,
                    stats.getRecentRunTotals().getElevationGain()));
        }
        builder.append("\nPlease summarize the athlete's current level of activity and historical highlights.");
        
        return chatClient.prompt()
                .user(builder.toString())
                .call()
                .content();
    }
}
