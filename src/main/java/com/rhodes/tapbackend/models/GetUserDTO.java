package com.rhodes.tapbackend.models;

public class GetUserDTO {

    private String username;

    public GetUserDTO() {
    }

    public GetUserDTO(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
