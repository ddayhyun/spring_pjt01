package com.example.spring_pjt01.blog.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; // 수정된 부분
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_pjt01.blog.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    
    // 특정 게시물에 대한 댓글 목록 조회
    List<Comment> findByPostId(Long postId);
    Page<Comment> findByPostId(Long postId, Pageable pageable);
    
    // 댓글 삭제 (JpaRepository에서 기본 제공)
    // void deleteById(Long id);
}
