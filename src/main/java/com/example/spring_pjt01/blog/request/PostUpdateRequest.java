package com.example.spring_pjt01.blog.request;

import lombok.Data;

@Data
public class PostUpdateRequest {
    private String title;
    private String content;
}