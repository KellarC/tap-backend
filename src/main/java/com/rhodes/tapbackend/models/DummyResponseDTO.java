package com.rhodes.tapbackend.models;

public class DummyResponseDTO {

    private String message;

    public DummyResponseDTO() {
    }

    public DummyResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
