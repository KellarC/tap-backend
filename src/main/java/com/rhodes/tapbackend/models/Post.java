package com.rhodes.tapbackend.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="post_id")
    private Integer postId;
    @Column(name="poster")
    private String poster;
    @Column(name="message")
    private String message;
    @Column(name="date")
    private LocalDate date; //yyyy-MM-dd
    @Column(name="time")
    private String time; //HH:mm

    public Post() {
    }

    public Post(Integer postId, String poster, String message, LocalDate date, String time) {
        this.postId = postId;
        this.poster = poster;
        this.message = message;
        this.date = date;
        this.time = time;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
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

    public String getTime() { return time; }

    public void setTime(String time) { this.time = time; }
}
