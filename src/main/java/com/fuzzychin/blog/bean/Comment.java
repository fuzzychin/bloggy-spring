package com.fuzzychin.blog.bean;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import java.util.Date;

@Table(name = "comments")
@Entity
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(nullable = false)
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @Column(name = "created_on", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Column(name = "modified_on", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedOn;

    @Column(name = "deleted_on", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedOn;

    public Comment(){};

    public Comment(long id, String body, User user, Post post, Date createdOn, Date modifiedOn, Date deletedOn) {
        this.id = id;
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

    @PrePersist
    private void onSave(){
        if(this.createdOn==null){
            this.createdOn = new Date();
        }

        this.modifiedOn = new Date();
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

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public Date getDeletedOn() {
        return deletedOn;
    }

    public void setDeletedOn(Date deletedOn) {
        this.deletedOn = deletedOn;
    }
}