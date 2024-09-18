package com.example.spring_pjt01.blog.response;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor 
public class CommentListReadResponse {

    private final Integer totalPages;
    private final Integer pageNumber;
    private final Integer pageSize;
    private final Long totalElements;
    private final List<com.example.spring_pjt01.blog.Comment> comments;

    public CommentListReadResponse(List<com.example.spring_pjt01.blog.Comment> comments2) {
        this.comments = comments2;
        this.totalPages = 1; // 기본값 설정
        this.pageNumber = 1; // 기본값 설정
        this.pageSize = comments2.size(); // 댓글 수에 따라 페이지 크기 설정
        this.totalElements = (long) comments2.size(); // 총 댓글 수
    }

    @Getter
    @RequiredArgsConstructor
    public static class Comment {
        private final Long id;
        private final String content;
        private final String author;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
        private final LocalDateTime createdTime;
    }
}
