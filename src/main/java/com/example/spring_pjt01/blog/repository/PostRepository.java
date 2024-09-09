package com.example.spring_pjt01.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_pjt01.blog.model.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
    
}