package com.rhodes.tapbackend.models;

public class ViewFollowersFollowingDTO {
    private Integer user_id;

    public ViewFollowersFollowingDTO() {
    }

    public ViewFollowersFollowingDTO(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
}
