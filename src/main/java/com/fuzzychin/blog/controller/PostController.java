package com.fuzzychin.blog.controller;

import com.fuzzychin.blog.bean.Post;
import com.fuzzychin.blog.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/post")
public class PostController {

    static private Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    public PostController(){
    }

    @RequestMapping(path="/", method= RequestMethod.GET)
    public ResponseEntity<?> queryPost(){

        //TODO query DB - use findAll()
        List<Post> response = postService.findAll();

        return ResponseEntity.ok("DB Response");
    }


}