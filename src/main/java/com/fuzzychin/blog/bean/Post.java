package com.fuzzychin.blog.bean;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fuzzychin.blog.Slug;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "Posts")
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String slugTitle;

    @Column(nullable = false)
    private String body;

    @JsonManagedReference
    @ManyToOne
    private User user;

    @JsonManagedReference
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "posts")
    private List<Tag> tags;

    @Column(name = "created_on", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Column(name = "modified_on", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedOn;

    @Column(name = "deleted_on", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedOn;

    public Post(){};


    @PrePersist
    private void onSave(){
        if(this.createdOn==null){
            this.createdOn = new Date();
        }

        this.modifiedOn = new Date();

        Slug slug = new Slug();
        this.slugTitle = slug.dasher(getTitle());

    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlugTitle() {
        return slugTitle;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
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
