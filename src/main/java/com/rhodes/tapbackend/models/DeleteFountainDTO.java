package com.rhodes.tapbackend.models;

public class DeleteFountainDTO {
    private Integer fountainId;

    public DeleteFountainDTO() {
    }

    public DeleteFountainDTO(Integer fountainId) {
        this.fountainId = fountainId;
    }

    public Integer getFountainId() {
        return fountainId;
    }

    public void setFountainId(Integer fountainId) {
        this.fountainId = fountainId;
    }
}
