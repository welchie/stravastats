package org.weewelchie.strava.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties
public class StravaAthlete {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("username")
    private String userName;

    @JsonProperty("resource_state")
    private String resourceState;

    @JsonProperty("firstname")
    private String firstName;

    @JsonProperty("lastname")
    private String lastName;

    @JsonProperty("bio")
    private String bio;

    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("country")
    private String country;

    @JsonProperty("sex")
    private String sex;

    @JsonProperty("premium")
    private String premium;

    @JsonProperty("summit")
    private String summit;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("badge_type_id")
    private String badge_type_id;

    @JsonProperty("weight")
    private String weight;

    @JsonProperty("profile_medium")
    private String profile_medium;

    @JsonProperty("profile")
    private String profile;

    @JsonProperty("friend")
    private String friend;

    @JsonProperty("follower")
    private String follower;



}
