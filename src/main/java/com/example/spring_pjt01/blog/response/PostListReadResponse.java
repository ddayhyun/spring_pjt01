package com.example.spring_pjt01.blog.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class PostListReadResponse {

    private final Integer totalPages;
    private final Integer pageNumber;
    private final Integer pageSize;
    private final Long totalElements;
    private final List<com.example.spring_pjt01.blog.Post> posts;

    // int와 long을 받는 생성자 추가
    public PostListReadResponse(int totalPages, Integer pageNumber, Integer pageSize, long totalElements, List<com.example.spring_pjt01.blog.Post> list) {
        this.totalPages = totalPages; // int를 Integer로 변환
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalElements = totalElements; // long을 Long으로 변환
        this.posts = list;
    }
    
    @Getter
    @RequiredArgsConstructor
    public static class Post {
        private final Long id;
        private final String title;
        private final String author;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
        private final LocalDateTime createdTime;
    }
}
