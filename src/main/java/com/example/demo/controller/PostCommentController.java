package com.example.demo.controller;

import com.example.demo.domain.PostComment;
import com.example.demo.repository.PostCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostCommentController {
    @Autowired
    private PostCommentRepository postCommentRepository;

    @GetMapping("post-comment")
    public Iterable<PostComment> getAll() {
        return postCommentRepository.findAll();
    }

    @GetMapping("post-comment/{post_id}")
    public Iterable<PostComment> getByPost(@PathVariable Long post_id) {
        return postCommentRepository.findByPostId(post_id);
    }

    @PostMapping("post-comment")
    public PostComment create(@RequestBody PostComment postComment){
        return postCommentRepository.save(postComment);
    }

    @PutMapping("post-comment")
    public PostComment update(@RequestBody PostComment postComment) {
        return postCommentRepository.save(postComment);
    }

    @DeleteMapping("post-comment/{id}")
    public void delete(@PathVariable Long id) {
        postCommentRepository.deleteById(id);
    }


}
