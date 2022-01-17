package com.example.demo.controller;

import com.example.demo.util.ErrorMessage;
import com.example.demo.domain.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;

@RestController
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("post")
    public Iterable<Post> getAll() {
        return postRepository.findAll();
    }

//    //Bez kontrole
//    @PostMapping("post")
//    public Post create(@RequestBody Post post){
//        return postRepository.save(post);
//    }

    //Sa kontrolom pomocu @ExceptionHandler metode
    @PostMapping("post")
    public Post create(@RequestBody Post post) throws ValidationException{
        if(post.getId() == 0 && post.getTitle() != null)
            return postRepository.save(post);
        else throw new ValidationException("Post can not be created!");
    }


//    //Bez kontrole
//    @PutMapping("post")
//    public Post update(@RequestBody Post post) { return postRepository.save(post); }

    //Sa kontrolom pomocu ResponseEntity
    @PutMapping("post")
    ResponseEntity<Post> update(@RequestBody Post post) {
        if(postRepository.findById(post.getId()).isPresent())
            return new ResponseEntity(postRepository.save(post), HttpStatus.OK);
        else
            return new ResponseEntity(post, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("post/{id}")
    public void delete(@PathVariable Long id) {
        postRepository.deleteById(id);
    }

    @GetMapping("wrong")
    public Post somethingIsWrong() throws ValidationException {
        throw new ValidationException("Something is wrong");
    }

    //Jednostavan - vraca string
    //Ovo nam treba za System Tests - testErrorHandlingReturnsBadRequest
    @ExceptionHandler(ValidationException.class)
    ResponseEntity<String> exceptionHandler(ValidationException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

//    //Kada je ovo zakomentarisano koristi @ControllerAdvice klasa ControllerExceptionHandler
//    //Poboljsan - vraca objekat clase ErrorMessage kao JSON
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(ValidationException.class)
//    public ErrorMessage exceptionHandler(ValidationException e) {
//        return new ErrorMessage("400", e.getMessage());
//    }
}
