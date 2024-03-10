package com.rhodes.tapbackend.models;

public class DeleteAccountDTO {
    private String username;

    public DeleteAccountDTO() {
    }

    public DeleteAccountDTO(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}