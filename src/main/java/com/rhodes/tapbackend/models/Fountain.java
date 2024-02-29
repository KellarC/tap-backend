package com.rhodes.tapbackend.models;

import jakarta.persistence.*;

@Entity
@Table(name="fountains")
public class Fountain {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="fountain_id")
    private Integer fountainId;

    @Column(name="x_coord")
    private float xCoord;

    @Column(name="y_coord")
    private float yCoord;

    @Column(name="description")
    private String description;

    @Column(name="rating")
    private float rating;

    @Column(name="verified")
    private boolean verified;

    @Column(name="author")
    private String author;

    public Fountain() {
        super();
    }

    public Fountain(Integer fountainId, float xCoord, float yCoord, String description, float rating, boolean verified, String author) {
        this.fountainId = fountainId;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.description = description;
        this.rating = rating;
        this.verified = verified;
        this.author = author;
    }

    public Integer getFountainId() {
        return fountainId;
    }

    public void setFountainId(Integer fountainId) {
        this.fountainId = fountainId;
    }

    public float getxCoord() {
        return xCoord;
    }

    public void setxCoord(float xCoord) {
        this.xCoord = xCoord;
    }

    public float getyCoord() {
        return yCoord;
    }

    public void setyCoord(float yCoord) {
        this.yCoord = yCoord;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Fountain{" +
                "fountainId=" + fountainId +
                ", xCoord=" + xCoord +
                ", yCoord=" + yCoord +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", verified=" + verified +
                ", author='" + author + '\'' +
                '}';
    }
}
