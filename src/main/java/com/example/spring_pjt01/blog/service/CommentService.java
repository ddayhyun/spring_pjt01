package com.example.spring_pjt01.blog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring_pjt01.blog.Comment;
import com.example.spring_pjt01.blog.Post;
import com.example.spring_pjt01.blog.repository.CommentRepository;
import com.example.spring_pjt01.blog.repository.PostRepository; // PostRepository 임포트 추가
import com.example.spring_pjt01.blog.request.CommentCreateRequest;
import com.example.spring_pjt01.blog.request.CommentUpdateRequest;
import com.example.spring_pjt01.blog.response.CommentListReadResponse;
import com.example.spring_pjt01.blog.response.CommentResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository; // PostRepository 추가

    public Page<Comment> getCommentsByPostId(Long postId, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return commentRepository.findByPostId(postId, pageRequest);
    }

    // 댓글 목록 조회
    public CommentListReadResponse getComments(Long postId, Integer page, Integer size) {
        @SuppressWarnings("unchecked")
        List<Comment> comments = (List<Comment>) commentRepository.findByPostId(postId, PageRequest.of(page, size));
        return new CommentListReadResponse(comments);
    }

    // 특정 댓글 조회
    public CommentResponse getComment(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.map(CommentResponse::new).orElse(null);
    }

    // 댓글 생성
    @Transactional
    public CommentResponse createComment(CommentCreateRequest request) {
        Comment comment = new Comment();
        
        // Post 객체를 가져오는 로직 추가
        Post post = postRepository.findById(request.getPostId())
            .orElseThrow(() -> new RuntimeException("Post not found")); // 예외 처리 추가
        
        comment.setPost(post); // setPost 메서드 사용
        comment.setContent(request.getContent());
        comment.setAuthor(request.getAuthor());
        
        comment = commentRepository.save(comment);
        return new CommentResponse(comment);
    }

    // 댓글 수정
    @Transactional
    public void updateComment(Long id, CommentUpdateRequest request) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (optionalComment.isPresent()) {
            Comment comment = optionalComment.get();
            comment.setContent(request.getContent());
            commentRepository.save(comment);
        }
    }

    // 댓글 삭제
    @Transactional
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
