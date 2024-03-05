package com.rhodes.tapbackend.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RegistrationDTO {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    public RegistrationDTO() {
        super();
    }

    public RegistrationDTO(String username, String password, String firstName, String lastName, String email) {
        super();
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        ObjectMapper map = new ObjectMapper();

        try {
            return map.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            System.out.println("Failed to encode to JSON");
        }
        return "Failed to encode JSON";
    }
}
