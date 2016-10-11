package com.fuzzychin.blog.service;


import com.fuzzychin.blog.bean.Post;
import com.fuzzychin.blog.bean.User;
import com.fuzzychin.blog.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostService implements PostRepository {

    static private Logger logger = LoggerFactory.getLogger(PostService.class);

    @Autowired
    public PostRepository postRepository;


    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public List<Post> findAllByUser(User user){
        List<Post> posts = postRepository.findAll(user);
    }
}
