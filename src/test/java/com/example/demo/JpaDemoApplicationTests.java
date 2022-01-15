package com.example.demo;

import com.example.demo.domain.Post;
import com.example.demo.domain.PostComment;
import com.example.demo.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
class JpaDemoApplicationTests {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private EntityManager entityManager;


	@Test
	void contextLoads() {
		final Post post=new Post();
		post.setTitle("Belgrade1");
		postRepository.save(post);
	}


	@Test
	void contextLoadsEntityManager() {
		final Post post=new Post();
		post.setTitle("Belgrade1");
		entityManager.persist(post);
	}

	private List<PostComment> addComments(Post post){
		final List<PostComment> postComments = new ArrayList<>();
		for(int i = 0; i < 5; i++){
			PostComment postComment=new PostComment();
			postComment.setReview("Review "+ i);
			postComment.setPost(post);
			postComments.add(postComment);
		}
		return postComments;
	}
}
