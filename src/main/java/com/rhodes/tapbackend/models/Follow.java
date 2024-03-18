package com.rhodes.tapbackend.models;

import jakarta.persistence.*;

@Entity
@Table(name="followers")
public class Follow {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="follower_id", referencedColumnName="user_id")
    private ApplicationUser follower;

    @ManyToOne
    @JoinColumn(name = "followee_id", referencedColumnName = "user_id")
    private ApplicationUser followee;

    public Follow(Integer id, ApplicationUser follower, ApplicationUser followee) {
        super();
        this.id = id;
        this.follower = follower;
        this.followee = followee;
    }

    public Follow() {
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
