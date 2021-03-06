package com.fuzzychin.blog.repository;


import com.fuzzychin.blog.bean.Post;
import com.fuzzychin.blog.bean.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    List<Tag> findByPosts(List<Post> posts);

}
