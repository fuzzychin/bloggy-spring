package com.fuzzychin.blog.service;

import com.fuzzychin.blog.bean.Comment;
import com.fuzzychin.blog.repository.CommentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    static private Logger logger = LoggerFactory.getLogger(CommentService.class);

    @Autowired
    public CommentRepository commentRepository;

    public List<Comment> findAll() {return commentRepository.findAll();}

    public void deleteComment(Comment comment) {commentRepository.delete(comment);}

    public Comment save(Comment comment) {return commentRepository.save(comment);}

    public Comment  findOneComment(long commentId) {return commentRepository.findOne(commentId);}

    public List<Comment> findAllByUser(long userId) {
        return commentRepository.findByUserId(userId);
    }

    public List<Comment> findAllByPost(long postId) {
        return commentRepository.findByPostId(postId);
    }

    public List<Comment> save(List<Comment> listOfComments) {return commentRepository.save(listOfComments);}

}
