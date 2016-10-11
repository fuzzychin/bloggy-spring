package com.fuzzychin.blog.service;


import com.fuzzychin.blog.bean.Post;
import com.fuzzychin.blog.bean.User;
import com.fuzzychin.blog.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//Repository is for JPA repositories or custom repository implementations.
@Repository
//We just need a class that interfaces with the PostRepository (see @Autowired).
public class PostService implements PostRepository {

    static private Logger logger = LoggerFactory.getLogger(PostService.class);

    //You would never Implement and @Autowire a dependency. However since we are not implementing the PostRepository we need to inject it here.
    @Autowired
    public PostRepository postRepository;


    public List<Post> findAll(){
        return postRepository.findAll();
    }

    //see comment in PostRepository.  I don't think this is the right way to do this
    public List<Post> findAllPostsByUser(User user){
        //If doing no manipulations why create a List<Post> to simply return it..
        //you can do the following: return postRepository.findAllByUser(user);
        //and accomplish the same thing with less redundant code.
        
        return postRepository.findAllByUser(user);
    }
    
    public Post findOnePost(){
        return postRepository.findOne();    
    }
}
