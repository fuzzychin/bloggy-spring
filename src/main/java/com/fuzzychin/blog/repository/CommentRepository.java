package com.fuzzychin.blog.repository;


import com.fuzzychin.blog.bean.Comment;
import com.fuzzychin.blog.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByUserId(long userId);

    List<Comment> findByPostId(long postId);

}
