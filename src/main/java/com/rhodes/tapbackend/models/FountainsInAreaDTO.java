package com.rhodes.tapbackend.models;

public class FountainsInAreaDTO {
    private float minLat;
    private float minLon;
    private float maxLat;
    private float maxLon;


    public FountainsInAreaDTO(float minLat, float minLon, float maxLat, float maxLon) {
        this.minLat = minLat;
        this.minLon = minLon;
        this.maxLat = maxLat;
        this.maxLon = maxLon;
    }

    public float getMinLat() {
        return minLat;
    }

    public float getMinLon() {
        return minLon;
    }

    public float getMaxLat() {
        return maxLat;
    }

    public float getMaxLon() {
        return maxLon;
    }

}
