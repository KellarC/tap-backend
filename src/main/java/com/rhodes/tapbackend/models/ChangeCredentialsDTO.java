package com.rhodes.tapbackend.models;

public class ChangeCredentialsDTO {
    private String username;
    private String newPassword;

    public ChangeCredentialsDTO() {
    }

    public ChangeCredentialsDTO(String username, String newPassword) {
        this.username = username;
        this.newPassword = newPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
