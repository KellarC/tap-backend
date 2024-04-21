package com.rhodes.tapbackend.models;

public class DeletePostDTO {

    private Integer post_id;
    private String requester;

    public DeletePostDTO() {
    }

    public DeletePostDTO(Integer post_id, String requester) {
        this.post_id = post_id;
        this.requester = requester;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }
}
