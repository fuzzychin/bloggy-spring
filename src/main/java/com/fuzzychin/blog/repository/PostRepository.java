package com.fuzzychin.blog.repository;


import com.fuzzychin.blog.bean.Post;
import com.fuzzychin.blog.bean.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAll();

    List<Post> findAll(User user);

    List<Post> findAll(Sort sort);
}
