package com.example.demo.repository;

import com.example.demo.domain.Post;
import com.example.demo.domain.PostComment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PostCommentRepository extends CrudRepository<PostComment,Long> {

    @Query("select p from PostComment p where p.post.id = ?1")
    Iterable<PostComment> findByPostId(Long post_id);

}
