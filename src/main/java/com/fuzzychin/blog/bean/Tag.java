package com.fuzzychin.blog.bean;

import javax.persistence.*;

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

    public Tag(){};

    public Tag(long id, String descriptor, String content) {
        this.id = id;
        this.descriptor = descriptor;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}
