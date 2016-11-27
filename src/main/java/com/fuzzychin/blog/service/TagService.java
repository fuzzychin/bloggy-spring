package com.fuzzychin.blog.service;


import com.fuzzychin.blog.bean.Post;
import com.fuzzychin.blog.bean.Tag;
import com.fuzzychin.blog.repository.TagRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    static private Logger logger = LoggerFactory.getLogger(TagService.class);

    @Autowired
    public TagRepository tagRepository;

    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    public void deleteTag(Tag tag) {
        tagRepository.delete(tag);
    }

    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag findOneTag(Long tagId) {
        return tagRepository.findOne(tagId);
    }

    public List<Tag> findAllByPosts(List<Post> posts) { return tagRepository.findByPosts(posts); }

    public List<Tag> save(List<Tag> tags) {
        return tagRepository.save(tags);
    }
}
