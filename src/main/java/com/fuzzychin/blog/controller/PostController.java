package com.fuzzychin.blog.controller;

import com.fuzzychin.blog.bean.Post;
import com.fuzzychin.blog.bean.Tag;
import com.fuzzychin.blog.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/post")
public class PostController {

    static private Logger logger = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    //Controller Method naming conventions
    // Query = Find All (return array/list)
    // Get = Find One
    // Update
    // Delete
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> queryPost(@RequestParam(required = false, name = "tags") Tag[] tags) {

        if (tags != null && tags.length > 0) {
            return ResponseEntity.ok(postService.findAll(Arrays.asList(tags)));
        }

        return ResponseEntity.ok(postService.findAll());
    }

    //We will query all posts by User off of the USER endpoint based on domain context.

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createPosts(@RequestBody Post post) {
        return ResponseEntity.ok(postService.save(post));
    }

    @RequestMapping(path = "/{postId}", method = RequestMethod.GET)
    public ResponseEntity<?> getPost(@PathVariable("postId") Long postId){
        return ResponseEntity.ok(postService.findOnePost(postId));
    }


    @RequestMapping(path = "/{postId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePost(@PathVariable("postId") Long postId, @RequestBody Post updatedPost) {
        Post post = postService.findOnePost(postId);
        if (post != null) {
            if (!post.getBody().equals(updatedPost.getBody())) {
                post.setBody(updatedPost.getBody());
            }
            if (!post.getTitle().equals(updatedPost.getTitle())) {
                post.setTitle(updatedPost.getTitle());
            }
            postService.save(post);
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(path = "/{postId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePost(@PathVariable("postId") Long postId) {
        Post post = postService.findOnePost(postId);
        if (post != null) {
            postService.deletePost(post);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(path = "/user/{userId}", method = RequestMethod.GET)
    public ResponseEntity<?> getPostsByUserId(@PathVariable("userId") Long userId){
        return ResponseEntity.ok(postService.findPostsByUserId(userId));
    }

}