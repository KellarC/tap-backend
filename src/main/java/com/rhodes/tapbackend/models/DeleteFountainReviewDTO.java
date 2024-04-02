package com.rhodes.tapbackend.models;

public class DeleteFountainReviewDTO {

    private Integer fountainId;

    private String reviewer;

    public DeleteFountainReviewDTO(Integer fountainId, String reviewer) {
        this.fountainId = fountainId;
        this.reviewer = reviewer;
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
}
