package com.example.blog.repository;

import com.example.blog.model.Post;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long> {
    
    @Query("SELECT p FROM Post p WHERE "+
           "LOWER(p.title) LIKE LOWER(CONCAT('%',:term,'%')) OR "+
           "LOWER(p.content) LIKE LOWER(CONCAT('%',:term,'%')) OR "+ 
           "LOWER(p.category) LIKE LOWER(CONCAT('%',:term,'%')) OR "+
           ":term MEMBER OF p.tags")
    List<Post> findByTerm(String term);
    
}
