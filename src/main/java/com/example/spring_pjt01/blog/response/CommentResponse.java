package com.example.spring_pjt01.blog.response;

import com.example.spring_pjt01.blog.Comment; // Comment 클래스 임포트
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommentResponse {
    private final Long id;
    private final String content;

    // Comment 객체를 매개변수로 받는 생성자 추가
    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
    }
}
