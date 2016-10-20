package com.fuzzychin.blog.service;


import com.fuzzychin.blog.bean.Comment;
import com.fuzzychin.blog.bean.Post;
import com.fuzzychin.blog.bean.User;
import com.fuzzychin.blog.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    static private Logger logger = LoggerFactory.getLogger(PostService.class);

    @Autowired
    public UserRepository userRepository;

    public List<User> findAll() { return userRepository.findAll(); }

    public User findAll(Post post)  {
        return userRepository.findByPosts(new ArrayList<Post>(1){{add(post);}});
    }

    public User findAll(List<Post> posts) { return userRepository.findByPosts(posts); }

    //Again not overriding findAll() method because below method has same erasure as above findAll() method
    public User findAllByComment(List<Comment> comments)   { return userRepository.findByComments(comments); }

    public User findOneUser(Long userId) {
        return userRepository.findOne(userId);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> save(List<User> user) {
        return userRepository.save(user);
    }



}
