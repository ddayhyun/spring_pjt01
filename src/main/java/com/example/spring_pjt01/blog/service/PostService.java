package com.example.spring_pjt01.blog.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_pjt01.blog.model.Post;
import com.example.spring_pjt01.blog.repository.PostRepository;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public Post createPost(Post post) {
        post.setCreatedDate(LocalDateTime.now());
        return postRepository.save(post);
    }

    // Update, Delete 메서드 추가
}

