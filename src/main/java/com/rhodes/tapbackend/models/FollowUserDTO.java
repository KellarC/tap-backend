package com.rhodes.tapbackend.models;

public class FollowUserDTO {

    private Integer follower_id;
    private Integer followee_id;

    public FollowUserDTO() {
    }

    public FollowUserDTO(Integer follower_id, Integer followee_id) {
        this.follower_id = follower_id;
        this.followee_id = followee_id;
    }

    public Integer getFollower_id() {
        return follower_id;
    }

    public void setFollower_id(Integer follower_id) {
        this.follower_id = follower_id;
    }

    public Integer getFollowee_id() {
        return followee_id;
    }

    public void setFollowee_id(Integer followee_id) {
        this.followee_id = followee_id;
    }
}
