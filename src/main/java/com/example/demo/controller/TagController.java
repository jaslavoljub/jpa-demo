package com.example.demo.controller;

import com.example.demo.domain.Tag;
import com.example.demo.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TagController {
    @Autowired
    private TagRepository tagRepository;

    @GetMapping("tag")
    public Iterable<Tag> getAll() {
        return tagRepository.findAll();
    }

    @PostMapping("tag")
    public Tag create(@RequestBody Tag tag){
        return tagRepository.save(tag);
    }

    @PutMapping("tag")
    public Tag update(@RequestBody Tag tag) {
        return tagRepository.save(tag);
    }

    @DeleteMapping("tag/{id}")
    public void delete(@PathVariable Long id) {
        tagRepository.deleteById(id);
    }

}
