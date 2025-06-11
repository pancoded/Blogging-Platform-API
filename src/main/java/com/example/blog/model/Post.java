package com.example.blog.model;

import com.example.blog.dto.PostDTO;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.Instant;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String category;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> tags;
    private Instant createdAt;
    private Instant updatedAt;
    
    public Post(PostDTO p){
        this.title = p.getTitle();
        this.content = p.getContent();
        this.category = p.getCategory();
        this.tags = p.getTags();
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }
    
}
