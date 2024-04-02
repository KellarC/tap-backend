package com.rhodes.tapbackend.models;

import jakarta.persistence.*;

@Entity
@Table(name="reviews")
public class FountainReview {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="review_id")
    private Integer reviewId;

    @Column(name="fountain_id")
    private Integer fountainID;

    @Column(name="reviewer")
    private String reviewer;

    @Column(name="description")
    private String description;

    @Column(name="rating")
    private float rating;

    public FountainReview() {
    }

    public FountainReview(Integer reviewId, Integer fountainID, String reviewer, String description, float rating) {
        this.reviewId = reviewId;
        this.fountainID = fountainID;
        this.reviewer = reviewer;
        this.description = description;
        this.rating = rating;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getFountainID() {
        return fountainID;
    }

    public void setFountainID(Integer fountainID) {
        this.fountainID = fountainID;
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
