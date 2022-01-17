package com.example.demo;

import com.example.demo.domain.Post;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class SystemTests {

    //Testiramo rad servisa (mora se prethodno pokrenuti aplikacija pre izvrsavanja testa komandom >mvn spring-boot:run)
    @Test
    public void testCreateReadDelete(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/post";

        Post post = new Post(0L,"Post001");
        ResponseEntity<Post> entity = restTemplate.postForEntity(url, post, Post.class);

        Post[] posts = restTemplate.getForObject(url, Post[].class);
        Assertions.assertThat(posts).extracting(Post::getTitle).containsExactly("Post001");

        restTemplate.delete(url + "/" + entity.getBody().getId());
        Assertions.assertThat(restTemplate.getForObject(url, Post[].class)).isEmpty();

    }

    @Test
    public void testErrorHandlingReturnsBadRequest() {

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/wrong";

        try {
            restTemplate.getForEntity(url, String.class);
        } catch (HttpClientErrorException e) {
            Assert.assertEquals(HttpStatus.BAD_REQUEST, e.getStatusCode());
        }
    }
}
