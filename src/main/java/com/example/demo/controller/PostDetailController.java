package com.example.demo.controller;

import com.example.demo.domain.PostDetail;
import com.example.demo.repository.PostDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostDetailController {
    @Autowired
    private PostDetailRepository postDetailRepository;

    @GetMapping("post-detail")
    public Iterable<PostDetail> getAll() {
        return postDetailRepository.findAll();
    }

    @PostMapping("post-detail")
    public PostDetail create(@RequestBody PostDetail postDetail){
        return postDetailRepository.save(postDetail);
    }

    @PutMapping("post-detail")
    public PostDetail update(@RequestBody PostDetail postDetail) {
        return postDetailRepository.save(postDetail);
    }

    @DeleteMapping("post-detail/{id}")
    public void delete(@PathVariable Long id) {
        postDetailRepository.deleteById(id);
    }
}
