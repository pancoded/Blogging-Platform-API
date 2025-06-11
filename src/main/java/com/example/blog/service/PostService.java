package com.example.blog.service;

import com.example.blog.dto.PostDTO;
import com.example.blog.model.Post;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.blog.repository.IPostRepository;
import jakarta.persistence.EntityNotFoundException;
import java.time.Instant;

@Service
public class PostService implements IPostService{
    
    @Autowired
    private IPostRepository postRepo;

    @Override
    public void savePost(PostDTO p) {
        Post post = new Post(p);
        postRepo.save(post);
    }

    @Override
    public List<Post> getPosts() {
        return postRepo.findAll();
    }

    @Override
    public Post findPost(Long id) {
        return postRepo.findById(id).orElse(null);
    }

    @Override
    public void deletePost(Long id) {
        if (!postRepo.existsById(id)) {
        throw new EntityNotFoundException();
        }
        postRepo.deleteById(id);
    }

    @Override
    public void editPost(Long id, PostDTO p) {
        Post post = this.findPost(id);
        post.setTitle(p.getTitle());
        post.setContent(p.getContent());
        post.setCategory(p.getCategory());
        post.setTags(p.getTags());
        post.setUpdatedAt(Instant.now());
        postRepo.save(post);
    }

    @Override
    public List<Post> findPostByTerm(String term) {
        return postRepo.findByTerm(term);
    }
    
}
