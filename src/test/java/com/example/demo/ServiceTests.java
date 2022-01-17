package com.example.demo;

import com.example.demo.domain.Post;
import com.example.demo.repository.PostRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ServiceTests {

    @Autowired
    PostRepository postRepository;

    @Test
    public void testCreateReadDelete(){
        Post post = new Post(0l,"Post01");
        postRepository.save(post);

        Iterable<Post> posts = postRepository.findAll();
        Assertions.assertThat(posts).extracting(Post::getTitle).containsOnly("Post01");

        postRepository.deleteAll();
        Assertions.assertThat(postRepository.findAll()).isEmpty();
    }
}
