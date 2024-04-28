package com.rhodes.tapbackend.models;

public class WaterDTO {

    private String username;

    private float ozOfWater;

    public WaterDTO() {
    }

    public WaterDTO(String username, float ozOfWater) {
        this.username = username;
        this.ozOfWater = ozOfWater;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getOzOfWater() {
        return ozOfWater;
    }

    public void setOzOfWater(float ozOfWater) {
        this.ozOfWater = ozOfWater;
    }
}
