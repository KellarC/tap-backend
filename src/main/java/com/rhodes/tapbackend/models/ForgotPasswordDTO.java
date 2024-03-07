package com.rhodes.tapbackend.models;

public class ForgotPasswordDTO {
    private String username;

    public ForgotPasswordDTO() {
    }

    public ForgotPasswordDTO(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}