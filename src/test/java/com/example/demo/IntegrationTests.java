package com.example.demo;

import com.example.demo.controller.PostController;
import com.example.demo.domain.Post;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ValidationException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTests {
    @Autowired
    PostController postController;

    @Test
    public void testCreateReadDelete(){
        Post post = new Post(0l,"Post01");
        Post postResult = postController.create(post);

        Iterable<Post> posts = postController.getAll();
        Assertions.assertThat(posts).first().hasFieldOrPropertyWithValue("title","Post01");

        postController.delete(postResult.getId());
        Assertions.assertThat(postController.getAll()).isEmpty();
    }


    @Test(expected = ValidationException.class)
    public void errorHandlingValidationExceptionThrown() {
        postController.somethingIsWrong();
    }
}
