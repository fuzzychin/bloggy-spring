package com.fuzzychin.blog.service;


import com.fuzzychin.blog.bean.User;
import com.fuzzychin.blog.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    static private Logger logger = LoggerFactory.getLogger(PostService.class);

    @Autowired
    public UserRepository userRepository;

    public List<User> findAll() { return userRepository.findAll(); }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findOneUser(Long userId) {
        return userRepository.findOne(userId);
    }

    public List<User> save(List<User> user) {
        return userRepository.save(user);
    }

}
