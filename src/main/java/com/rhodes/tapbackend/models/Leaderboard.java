package com.rhodes.tapbackend.models;

import jakarta.persistence.*;

@Entity
@Table(name="leaderboard")
public class Leaderboard {

    @Id
    @Column(name="username")
    private String username;

    @Column(name="points")
    private float points;

    @Column(name="oz_of_water")
    private float ozOfWater;

    public Leaderboard() {
    }

    public Leaderboard(String username, float points, float ozOfWater) {
        this.username = username;
        this.points = points;
        this.ozOfWater = ozOfWater;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getPoints() {
        return points;
    }

    public void setPoints(float points) {
        this.points = points;
    }

    public float getOzOfWater() {
        return ozOfWater;
    }

    public void setOzOfWater(float ozOfWater) {
        this.ozOfWater = ozOfWater;
    }
}
