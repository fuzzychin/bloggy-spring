package com.fuzzychin.blog.service;


import com.fuzzychin.blog.bean.Comment;
import com.fuzzychin.blog.bean.Post;
import com.fuzzychin.blog.bean.Tag;
import com.fuzzychin.blog.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Repository is for JPA repositories or custom repository implementations.
//We just need a class that interfaces with the PostRepository (see @Autowired).
@Service
public class PostService {
    /*
    Because we are creating a Service to play the middleman in the Controller (api endpoint) to Repository (database)
    we can use any naming conventions we want for the methods as they have no "Magic" behind them. The only place that
    method names have "magic" (in our example) are in the JPARepositories. So these method names should be logical/descriptive
    to the nature of what they are doing.
     */
    static private Logger logger = LoggerFactory.getLogger(PostService.class);

    //You would never Implement and @Autowire a dependency.
    //However since we are not implementing the PostRepository we need to inject it here.
    @Autowired
    public PostRepository postRepository;


    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public List<Post> findAll(Tag tag) {
        return postRepository.findByTags(new ArrayList<Tag>(1){{add(tag);}});
    }

    public List<Post> findAll(List<Tag> tags) {
        return postRepository.findByTags(tags);
    }

    public Post findAll(Comment comment) { return postRepository.findByComments(new ArrayList<Comment>(1){
        {add(comment);}}); }

    //originally named findAll but got an error saying it had same erasure as findAll(List<Tag> tags)
    public Post findAllComments(List<Comment> comments) { return postRepository.findByComments(comments);}

    public Post findOnePost(Long postId) {
        return postRepository.findOne(postId);
    }

    public void deletePost(Post post) {
        postRepository.delete(post);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public List<Post> save(List<Post> posts) {
        return postRepository.save(posts);
    }


}
