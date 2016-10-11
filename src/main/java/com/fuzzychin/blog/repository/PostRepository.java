package com.fuzzychin.blog.repository;


import com.fuzzychin.blog.bean.Post;
import com.fuzzychin.blog.bean.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//TODO read the link below.
//http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation

public interface PostRepository extends JpaRepository<Post, Long> {

    /*List<Post> findAll();
    
    List<Post> findAllByUser(User user);

    Post findOne(Long id);*/
}
