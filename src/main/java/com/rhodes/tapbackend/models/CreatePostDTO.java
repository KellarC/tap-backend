package com.rhodes.tapbackend.models;

import java.time.LocalDate;

public class CreatePostDTO {

    private String poster;
    private String message;
    private LocalDate date;
    private Integer hour;
    private Integer minute;

    public CreatePostDTO() {
    }

    public CreatePostDTO(String poster, String message, LocalDate date, Integer hour, Integer minute) {
        this.poster = poster;
        this.message = message;
        this.date = date;
        this.hour = hour;
        this.minute = minute;
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

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }
}
