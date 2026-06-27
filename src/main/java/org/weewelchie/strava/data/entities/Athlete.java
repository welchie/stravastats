package org.weewelchie.strava.data.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name="athlete")
public class Athlete {

    @Id
    private Long id;

    @Column(name="user_name")
    private String userName;

    @Column(name ="resource_state")
    private String resourceState;

    @Column(name ="firstname")
    private String firstName;

    @Column(name ="lastname")
    private String lastName;

    @Column(name ="bio")
    private String bio;

    @Column(name ="city")
    private String city;

    @Column(name ="state")
    private String state;

    @Column(name ="country")
    private String country;

    @Column(name ="sex")
    private String sex;

    @Column(name ="premium")
    private String premium;

    @Column(name ="summit")
    private String summit;

    @Column(name ="created_at")
    private String createdAt;

    @Column(name ="updated_at")
    private String updatedAt;

    @Column(name ="badge_type_id")
    private String badge_type_id;

    @Column(name ="weight")
    private String weight;

    @Column(name ="profile_medium")
    private String profile_medium;

    @Column(name ="profile")
    private String profile;

    @Column(name ="friend")
    private String friend;

    @Column(name ="follower")
    private String follower;




}
