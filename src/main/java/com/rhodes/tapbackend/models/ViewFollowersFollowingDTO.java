package com.rhodes.tapbackend.models;

public class ViewFollowersFollowingDTO {
    private String username;

    public ViewFollowersFollowingDTO() {
    }

    public ViewFollowersFollowingDTO(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
