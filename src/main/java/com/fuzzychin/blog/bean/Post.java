package com.fuzzychin.blog.bean;

import javax.persistence.*;
import java.util.List;

@Table(name="Posts")
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String body;

    @Column
    @ManyToOne
    private User user;

    @Column
    @ManyToMany
    private List<Tag> tags;

    @Column(nullable = false)
    private  String createdOn;

    @Column(nullable = false)
    private  String modifiedOn;

    @Column(nullable = false)
    private  String deletedOn;

    public Post(){};

    private Post(long id, String title, String body, User user, List<Tag> tags, String createdOn, String modifiedOn, String deletedOn) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
        this.tags = tags;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.deletedOn = deletedOn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
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
