package com.rhodes.tapbackend.models;

public class PostsByUserDTO {

    private String username;

    public PostsByUserDTO() {
    }

    public PostsByUserDTO(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
