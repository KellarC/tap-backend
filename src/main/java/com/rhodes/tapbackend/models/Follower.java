package com.rhodes.tapbackend.models;

import jakarta.persistence.*;

@Entity
@Table(name="followers")
public class Follower {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="follower", referencedColumnName="username")
    private ApplicationUser follower;

    @ManyToOne
    @JoinColumn(name="followee", referencedColumnName="username")
    private ApplicationUser followee;

    public Follower() {
    }

    public Follower(Integer id, ApplicationUser follower, ApplicationUser followee) {
        this.id = id;
        this.follower = follower;
        this.followee = followee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ApplicationUser getFollower() {
        return follower;
    }

    public void setFollower(ApplicationUser follower) {
        this.follower = follower;
    }

    public ApplicationUser getFollowee() {
        return followee;
    }

    public void setFollowee(ApplicationUser followee) {
        this.followee = followee;
    }
}
