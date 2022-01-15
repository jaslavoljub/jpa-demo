package com.example.demo.controller;

import com.example.demo.domain.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;

@RestController
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("post")
    public Iterable<Post> getAll() {
        return postRepository.findAll();
    }

    @PostMapping("post")
    public Post create(@RequestBody Post post){
        return postRepository.save(post);
    }

    @PutMapping("post")
    public Post update(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @DeleteMapping("post/{id}")
    public void delete(@PathVariable Long id) {
        postRepository.deleteById(id);
    }

    @GetMapping("wrong")
    public Post somethingIsWrong() throws ValidationException {
        throw new ValidationException("Something is wrong");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public String exceptionHandler(ValidationException e) {
        return e.getMessage();
    }

}
