package org.weewelchie.strava.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.jdi.DoubleValue;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties
public class StravaActivity {

    @JsonProperty("resource_state")
    private String resourceState;

    @JsonProperty("athlete")
    private StravaAthlete stravaAthlete;

    @JsonProperty("name")
    private String name;

    @JsonProperty("distance")
    private Double distance;

    @JsonProperty("moving_time")
    private Integer movingTime;

    @JsonProperty("elapsed_time")
    private Integer elapsedTime;

    @JsonProperty("total_elevation_gain")
    private Integer totalElevationGain;

    @JsonProperty("type")
    private String type;

    @JsonProperty("sport_type")
    private String sportType;

    @JsonProperty("workout_type")
    private String workoutType;

    @JsonProperty("id")
    private String id;

    @JsonProperty("start_date")
    private String startDate;

    @JsonProperty("start_date_local")
    private String startDateLocal;

    @JsonProperty("timezone")
    private String timeZone;

    @JsonProperty("utc_offset")
    private String utcOffset;

    @JsonProperty("location_city")
    private String locationCity;

    @JsonProperty("location_county")
    private String locationCounty;

    @JsonProperty("location_state")
    private String locationState;

    @JsonProperty("location_country")
    private String locationCountry;

    @JsonProperty("achievement_count")
    private String achievementCount;

    @JsonProperty("kudos_count")
    private String kudos_count;

    @JsonProperty("comment_count")
    private String comment_count;

    @JsonProperty("athlete_count")
    private String athleteCount;

    @JsonProperty("photo_count")
    private String photo_count;

    @JsonProperty("map")
    private StravaMap map;

    @JsonProperty("trainer")
    private String trainer;

    @JsonProperty("commute")
    private String commute;

    @JsonProperty("manual")
    private String manual;

    @JsonProperty("private")
    private String privateActivity;

    @JsonProperty("visibility")
    private String visibility;

    @JsonProperty("flagged")
    private String flagged;

    @JsonProperty("gear_id")
    private String gearId;

    @JsonProperty("start_latlng")
    private String[] startLatlng;

   @JsonProperty("end_latlng")
   private String[] endLatlng;

    @JsonProperty("sverasge_speed")
    private String averageSpeed;

    @JsonProperty("max_speed")
    private String maxSpeed;

    @JsonProperty("average_cadence")
    private String averageCadence;

    @JsonProperty("has_heartrate")
    private String hasHeartRate;

    @JsonProperty("average_heartrate")
    private String averageHeartrate;

    @JsonProperty("max_heartrate")
    private String maxHeartrate;

    @JsonProperty("heartrate_opt_out")
    private String heartrateOptOut;

    @JsonProperty("display_hide_heartrate_option")
    private String displayHideHeartrateOption;

    @JsonProperty("elev_high")
    private String elevationHigh;

    @JsonProperty("elev_low")
    private String elevstionLow;

    @JsonProperty("upload_id")
    private String uploadId;

    @JsonProperty("upload_id_str")
    private String uplaodIdStr;

    @JsonProperty("external_id")
    private String externalId;

    @JsonProperty("from_accepted_tag")
    private String fromAcceptedTag;

    @JsonProperty("pr_count")
    private String prCount;

    @JsonProperty("total_photo_count")
    private String totalPhotoCount;

    @JsonProperty("has_kudoed")
    private String hasKudoed;


    /*

        "from_accepted_tag": false,
        "pr_count": 0,
        "total_photo_count": 0,
        "has_kudoed": false
    }

     */
}
