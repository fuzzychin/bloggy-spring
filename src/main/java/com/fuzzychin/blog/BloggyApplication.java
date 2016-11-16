package com.fuzzychin.blog;

import com.fuzzychin.blog.bean.Post;
import com.fuzzychin.blog.bean.User;
import com.fuzzychin.blog.repository.PostRepository;
import com.fuzzychin.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class BloggyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloggyApplication.class, args);
	}


}

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
class SeedUser implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setUserName("FuzzyChinSeed");
		user.setFirstName("Fuzzy");
		user.setLastName("Fuzzy");
		user.setEmailAddress("FuzzyChin@gmail.com");
		userRepository.save(user);
	}
}

@Component
class SeedPosts implements CommandLineRunner{

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		Post post = new Post();
		post.setBody("Seeded Post");
		post.setTitle("Seeded Title");
		post.setUser(userRepository.findOne((long) 1));
		postRepository.save(post);
	}
}