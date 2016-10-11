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

        //I don't think this is the correct way to put reponse in the body
        //it actually is if it is a 200 OK response, its a shortcut to ResponseEntity.ok().body(response).build();
        return ResponseEntity.ok(response);
    }
    
        @RequestMapping(path="/", method= RequestMethod.GET)
    public ResponseEntity<?> queryOnePost(){

        //TODO query DB - use findAll()
        List<Post> response = postService.findOnePost();
        return ResponseEntity.ok(response);
    }
    
    @RequestMapping(path="/", method= RequestMethod.GET)
    public ResponseEntity<?> queryPostsByUser(User user){
        return ResponseEntity.ok(postService.findAllByUser(user));
    }
    
    @RequestMapping(path="/", method= RequestMethod.POST)
    public ResponseEntity<?> queryPosts(){
        
        return ResponseEntity.ok(postService.save);
    }
    
    



}