package com.rhodes.tapbackend.models;

public class FountainDTO {

    private float xCoord;
    private float yCoord;
    private String description;
    private float rating;
    private String author;

    public FountainDTO() { super(); }

    public FountainDTO(float xCoord, float yCoord, String description, float rating, String author) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.description = description;
        this.rating = rating;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "FountainDTO{" +
                "xCoord=" + xCoord +
                ", yCoord=" + yCoord +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
