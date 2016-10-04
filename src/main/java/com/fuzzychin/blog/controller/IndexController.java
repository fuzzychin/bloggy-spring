package com.fuzzychin.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/$")
public class IndexController {

    static private Logger logger = LoggerFactory.getLogger(IndexController.class);

    /*This will be used for sending back the template 'index.html' found in src/main/resources/templates/index.html*/
    public String index(){
        return "index";
    }
}