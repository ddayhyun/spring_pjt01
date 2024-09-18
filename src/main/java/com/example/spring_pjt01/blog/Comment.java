package com.example.spring_pjt01.blog;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 댓글 ID
    @ManyToOne // 여러 댓글이 하나의 게시물에 속함
    @JoinColumn(name = "post_id", nullable = false) // 외래 키 설정
    private Post post;
    private String content; // 댓글 내용
    private String author; // 댓글 작성자
    private LocalDateTime createdAt; // 댓글 작성 시간

   
}