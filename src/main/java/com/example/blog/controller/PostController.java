package com.example.blog.controller;

import com.example.blog.dto.PostDTO;
import com.example.blog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.blog.service.IPostService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private IPostService postServ;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void savePost(@RequestBody PostDTO b) {
        postServ.savePost(b);
    }

    @GetMapping
    @ResponseBody
    public List<Post> getPosts() {
        return postServ.getPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findPost(@PathVariable Long id) {
        Post post = postServ.findPost(id);
        if (post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Post editPost(@PathVariable Long id, @RequestBody PostDTO p){
        postServ.editPost(id, p);
        return postServ.findPost(id);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id){
        try{
            postServ.deletePost(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }    
    }
    
    @GetMapping("/search")
    @ResponseBody
    public List<Post> searchPostByTerm(@RequestParam String term){
        return postServ.findPostByTerm(term);
    }
    
}