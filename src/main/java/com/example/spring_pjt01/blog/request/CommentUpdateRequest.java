package com.example.spring_pjt01.blog.request;

import lombok.Data;

@Data
public class CommentUpdateRequest {
    private Long postId; // 댓글이 달릴 게시물 ID
    private String content; // 댓글 내용
    private String author; // 댓글 작성자
}
