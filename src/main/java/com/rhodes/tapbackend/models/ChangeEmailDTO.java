package com.rhodes.tapbackend.models;

public class ChangeEmailDTO {
    private String username;
    private String newEmail;

    public ChangeEmailDTO() {
    }

    public ChangeEmailDTO(String username, String newEmail) {
        this.username = username;
        this.newEmail = newEmail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }
}