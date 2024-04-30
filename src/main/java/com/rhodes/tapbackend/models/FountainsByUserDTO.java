package com.rhodes.tapbackend.models;

public class FountainsByUserDTO {

    private String username;

    public FountainsByUserDTO() {
        username = "";
    }

    public FountainsByUserDTO(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }
}
