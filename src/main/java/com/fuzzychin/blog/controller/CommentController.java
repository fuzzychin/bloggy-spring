package com.fuzzychin.blog.controller;

import com.fuzzychin.blog.bean.Comment;
import com.fuzzychin.blog.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    static private Logger logger = LoggerFactory.getLogger(CommentController.class);


    @Autowired
    public CommentService commentService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> queryComment() {
        return ResponseEntity.ok(commentService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createComment(@RequestBody Comment comment){
        return ResponseEntity.ok(commentService.save(comment));
    }

    @RequestMapping(path = "/{commentId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateComment(@PathVariable("commentId") Long commentId, @RequestBody Comment updatedComment) {
        Comment comment = commentService.findOneComment(commentId);
        if (comment != null) {
            if (!comment.getBody().equals(updatedComment.getBody())) {
                comment.setBody(updatedComment.getBody());
            }

            commentService.save(comment);
            return ResponseEntity.ok(comment);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @RequestMapping(path = "/{commentId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteComment(@PathVariable("commentId") Long commentId) {
        Comment comment = commentService.findOneComment(commentId);
        if(comment !=null){
            commentService.deleteComment(comment);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @RequestMapping(path = "/comment/{commentId)", method = RequestMethod.GET)
    public ResponseEntity<?> queryCommentByCommentId(@PathVariable("commentId")Long commentId){
        return ResponseEntity.ok(commentService.findOneComment(commentId));
    }

}