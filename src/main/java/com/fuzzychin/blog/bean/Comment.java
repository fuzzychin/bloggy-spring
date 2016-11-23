package com.fuzzychin.blog.bean;

import javax.persistence.*;

@Table(name="comments")
@Entity
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(nullable = false)
    private String body;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;

    //@Column(nullable = false)
    private  String createdOn;

    //@Column(nullable = false)
    private  String modifiedOn;

    //@Column(nullable = false)
    private  String deletedOn;

    public Comment(){}

    public Comment(String body, User user, Post post, String createdOn, String modifiedOn, String deletedOn) {
        this.body = body;
        this.user = user;
        this.post = post;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.deletedOn = deletedOn;
    }
    public Comment(String body, User user, Post post) {
        this.body = body;
        this.user = user;
        this.post = post;
    }

    public long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public String getDeletedOn() {
        return deletedOn;
    }

    public void setDeletedOn(String deletedOn) {
        this.deletedOn = deletedOn;
    }
}
