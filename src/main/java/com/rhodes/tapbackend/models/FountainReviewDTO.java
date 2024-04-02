package com.rhodes.tapbackend.models;

public class FountainReviewDTO {

    private Integer fountainId;
    private String reviewer;
    private String description;
    private float rating;

    public FountainReviewDTO() {
    }

    public FountainReviewDTO(Integer fountainId, String reviewer, String description, float rating) {
        this.fountainId = fountainId;
        this.reviewer = reviewer;
        this.description = description;
        this.rating = rating;
    }

    public Integer getFountainId() {
        return fountainId;
    }

    public void setFountainId(Integer fountainId) {
        this.fountainId = fountainId;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
