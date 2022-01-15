package com.example.demo.repository;

import com.example.demo.domain.Tag;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> {

}
