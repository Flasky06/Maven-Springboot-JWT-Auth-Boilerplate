package com.todoapp.todo_auth.controller;

import com.todoapp.todo_auth.domain.dto.PostDto;
import com.todoapp.todo_auth.domain.entity.User;
import com.todoapp.todo_auth.service.PostService;
import com.todoapp.todo_auth.util.CurrentUserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        User user = CurrentUserUtil.getCurrentUser();
        return ResponseEntity.ok(postService.createPost(postDto, user));
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/me")
    public ResponseEntity<List<PostDto>> getMyPosts() {
        User user = CurrentUserUtil.getCurrentUser();
        return ResponseEntity.ok(postService.getPostsByUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable UUID id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable UUID id, @RequestBody PostDto postDto) {
        User user = CurrentUserUtil.getCurrentUser();
        return ResponseEntity.ok(postService.updatePost(id, postDto, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable UUID id) {
        User user = CurrentUserUtil.getCurrentUser();
        postService.deletePost(id, user);
        return ResponseEntity.noContent().build();
    }
}
