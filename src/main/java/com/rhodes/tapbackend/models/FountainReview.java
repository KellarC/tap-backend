package com.rhodes.tapbackend.models;

import jakarta.persistence.*;

@Entity
@Table(name="reviews")
public class FountainReview {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="review_id")
    private Integer reviewId;

    @Column(name="reviewer")
    private String reviewer;

    @Column(name="description")
    private String description;

    @Column(name="rating")
    private float rating;
}
