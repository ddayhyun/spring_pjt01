package com.example.spring_pjt01.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.spring_pjt01.blog.Post;
import com.example.spring_pjt01.blog.repository.PostRepository;
import com.example.spring_pjt01.blog.request.PostCreateRequest;
import com.example.spring_pjt01.blog.request.PostUpdateRequest;
import com.example.spring_pjt01.blog.response.PostCreateResponse;
import com.example.spring_pjt01.blog.response.PostListReadResponse;
import com.example.spring_pjt01.blog.response.PostReadResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

   public PostListReadResponse getPosts(Integer page, Integer size, String sort) {
    // 페이지 요청 생성
    PageRequest pageRequest = PageRequest.of(page, size);
    
    // 게시물 목록을 페이지 단위로 가져오기
    Page<Post> postPage = postRepository.findAll(pageRequest);
    
    // 총 페이지 수 계산
    int totalPages = postPage.getTotalPages();
    
    // PostListReadResponse 객체 생성
    PostListReadResponse response = new PostListReadResponse(
        totalPages, // 총 페이지 수
        page,       // 현재 페이지 번호
        size,       // 페이지 크기
        postPage.getTotalElements(), // 총 게시물 수
        postPage.getContent()         // 게시물 목록
    );
    
    return response; // 응답 반환
}


    public PostReadResponse getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("찾을수 없는 게시물"));
        // PostReadResponse로 변환하는 로직 필요
        return new PostReadResponse(post.getId(), post.getTitle(), post.getContent(), null, null);
    }

    public PostCreateResponse createPost(PostCreateRequest request) {
        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        Post savedPost = postRepository.save(post);
        return new PostCreateResponse(savedPost.getId(), savedPost.getTitle());
    }

    public void updatePost(Long id, PostUpdateRequest request) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("찾을수 없는 게시물"));
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
