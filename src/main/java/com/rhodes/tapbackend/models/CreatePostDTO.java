package com.rhodes.tapbackend.models;

import java.time.LocalDate;

public class CreatePostDTO {

    private String poster;
    private String message;
    private LocalDate date;

    public CreatePostDTO() {
    }

    public CreatePostDTO(String poster, String message, LocalDate date) {
        this.poster = poster;
        this.message = message;
        this.date = date;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}