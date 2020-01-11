package com.automation.web_services;

import lombok.Data;

@Data
public class PostEntity {

    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;

    public PostEntity(int postId, int id, String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }
}
