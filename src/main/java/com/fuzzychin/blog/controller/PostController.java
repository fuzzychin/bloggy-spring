package com.fuzzychin.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/post")
public class PostController {

    static private Logger logger = LoggerFactory.getLogger(PostController.class);

    public PostController(){
    }



/*    @ResponseBody
    String home() {
        return "Hello World!";
    }*/
}