package com.fuzzychin.blog.bean;

import javax.persistence.*;
import java.util.List;

@Table(name="Tags")
@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(nullable = false)
    private String descriptor;

    @Column(nullable = false)
    private String content;

    @ManyToMany
    private List<Post> posts;

    public Tag(){};

    public Tag(String descriptor, String content, List<Post> posts) {
        this.descriptor = descriptor;
        this.content = content;
        this.posts = posts;
    }

    public long getId() {
        return id;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
