package org.weewelchie.strava.data.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.weewelchie.strava.data.beans.StravaAthleteShort;
import org.weewelchie.strava.data.beans.StravaMap;

@Entity(name = "activity")
@Getter
@Setter
@ToString
public class Activity {

    @Id
    @Column (name="id")
    private Long id;

    @Column(name = "resource_state")
    private String resourceState;

    @OneToOne
    @JoinColumn(name = "athlete_id", referencedColumnName = "id")
    private Athlete athlete;

    @Column(name = "name")
    private String name;

    @Column(name = "distance")
    private Double distance;

    @Column(name = "moving_time")
    private Integer movingTime;

    @Column(name = "elapsed_time")
    private Integer elapsedTime;

    @Column(name = "total_elevation_gain")
    private Integer totalElevationGain;

    @Column(name = "type")
    private String type;

    @Column(name = "sport_type")
    private String sportType;

    @Column(name = "workout_type")
    private String workoutType;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "start_date_local")
    private String startDateLocal;

    @Column(name = "timezone")
    private String timeZone;

    @Column(name = "utc_offset")
    private String utcOffset;

    @Column(name = "location_city")
    private String locationCity;

    @Column(name = "location_county")
    private String locationCounty;

    @Column(name = "location_state")
    private String locationState;

    @Column(name = "location_country")
    private String locationCountry;

    @Column(name = "achievement_count")
    private String achievementCount;

    @Column(name = "kudos_count")
    private String kudos_count;

    @Column(name = "comment_count")
    private String comment_count;

    @Column(name = "athlete_count")
    private String athleteCount;

    @Column(name = "photo_count")
    private String photo_count;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "map_id")),
            @AttributeOverride(name = "resourceState", column = @Column(name = "map_resource_state"))
    })
    private StravaMap map;

    @Column(name = "trainer")
    private String trainer;

    @Column(name = "commute")
    private String commute;

    @Column(name = "manual")
    private String manual;

    @Column(name = "private")
    private String privateActivity;

    @Column(name = "visibility")
    private String visibility;

    @Column(name = "flagged")
    private String flagged;

    @Column(name = "gear_id")
    private String gearId;

    @Column(name = "start_latlng")
    private String[] startLatlng;

    @Column(name = "end_latlng")
    private String[] endLatlng;

    @Column(name = "average_speed")
    private String averageSpeed;

    @Column(name = "max_speed")
    private String maxSpeed;

    @Column(name = "average_cadence")
    private String averageCadence;

    @Column(name = "has_heartrate")
    private String hasHeartRate;

    @Column(name = "average_heartrate")
    private String averageHeartrate;

    @Column(name = "max_heartrate")
    private String maxHeartrate;

    @Column(name = "heartrate_opt_out")
    private String heartrateOptOut;

    @Column(name = "display_hide_heartrate_option")
    private String displayHideHeartrateOption;

    @Column(name = "elev_high")
    private String elevationHigh;

    @Column(name = "elev_low")
    private String elevationLow;

    @Column(name = "upload_id")
    private String uploadId;

    @Column(name = "upload_id_str")
    private String uploadIdStr;

    @Column(name = "external_id")
    private String externalId;

    @Column(name = "from_accepted_tag")
    private String fromAcceptedTag;

    @Column(name = "pr_count")
    private String prCount;

    @Column(name = "total_photo_count")
    private String totalPhotoCount;

    @Column(name = "has_kudoed")
    private String hasKudoed;
}
