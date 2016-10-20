package com.fuzzychin.blog.repository;


import com.fuzzychin.blog.bean.Comment;
import com.fuzzychin.blog.bean.Post;
import com.fuzzychin.blog.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByPosts(List<Post> post);

    User findByComments(List<Comment> comment);
}
