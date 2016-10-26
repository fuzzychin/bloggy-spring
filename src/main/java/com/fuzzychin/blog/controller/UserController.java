package com.fuzzychin.blog.controller;

import com.fuzzychin.blog.bean.Post;
import com.fuzzychin.blog.bean.User;
import com.fuzzychin.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


@RestController
@RequestMapping("/api/user")
public class UserController {

    static private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> queryPost(@RequestParam(required = false, name = "post")Post[] posts) {

        if(posts !=null && posts.length>0)
            return ResponseEntity.ok(userService.findAll(Arrays.asList(posts)));

        return ResponseEntity.ok(userService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> queryUsers(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @RequestMapping(path = "/{userId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@PathVariable("userId") Long userId, @RequestBody User updatedUser) {
        User user = userService.findOneUser(userId);
        if (user != null) {
            if (!user.getFirstName().equals(updatedUser.getFirstName())) {
                user.setFirstName(updatedUser.getFirstName());
            }
            if (!user.getLastName().equals(updatedUser.getLastName())) {
                user.setLastName(updatedUser.getLastName());
            }
            if (!user.getUserName().equals(updatedUser.getUserName())) {
                user.setUserName(updatedUser.getUserName());
            }
            if (!user.getEmailAddress().equals(updatedUser.getEmailAddress())) {
                user.setEmailAddress(updatedUser.getEmailAddress());
            }
            userService.save(user);
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(path = "/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Long userId) {
        User user = userService.findOneUser(userId);
        if (user != null) {
            userService.deleteUser(user);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}