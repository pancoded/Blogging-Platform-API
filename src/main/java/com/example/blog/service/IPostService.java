package com.example.blog.service;

import com.example.blog.dto.PostDTO;
import com.example.blog.model.Post;
import java.util.List;

public interface IPostService {
    
    public void savePost(PostDTO p);
    
    public List<Post> getPosts();
    
    public Post findPost(Long id);
    
    public void deletePost(Long id);
    
    public void editPost(Long id, PostDTO p);
    
    public List<Post> findPostByTerm(String term);
    
}
