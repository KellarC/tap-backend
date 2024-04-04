package com.rhodes.tapbackend.controllers;

import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.*;



@Entity
@Table(name = "reviews")
public class ReviewController {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "content")
    private String content;

    @Column(name = "likes")
    private int likes;

    @ElementCollection
    @CollectionTable(name = "review_comments", joinColumns = @JoinColumn(name = "review_id"))
    @Column(name = "comment")
    private List<String> comments = new ArrayList<>();

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }
}
