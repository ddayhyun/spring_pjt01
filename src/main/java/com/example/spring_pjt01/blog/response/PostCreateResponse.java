package com.example.spring_pjt01.blog.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostCreateResponse {
    private final Long id;
    private final String title;
}