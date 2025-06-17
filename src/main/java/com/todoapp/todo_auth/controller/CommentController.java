package com.todoapp.todo_auth.controller;

import com.todoapp.todo_auth.domain.dto.CommentDto;
import com.todoapp.todo_auth.domain.entity.Post;
import com.todoapp.todo_auth.domain.entity.User;
import com.todoapp.todo_auth.repository.PostRepository;
import com.todoapp.todo_auth.service.CommentService;
import com.todoapp.todo_auth.util.CurrentUserUtil;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final PostRepository postRepository;


    @PostMapping("/{postId}")
    public ResponseEntity<CommentDto> createComment(@PathVariable UUID postId,
                                                    @RequestBody @Valid CommentDto commentDto) {
        User user = CurrentUserUtil.getCurrentUser();
        if (user == null) {
            throw new SecurityException("User not authenticated");
        }
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("Post not found"));
        CommentDto createdComment = commentService.createComment(commentDto, user, post);
        return ResponseEntity.created(URI
                        .create("/api/comments/" + createdComment
                                .getId())).body(createdComment);

    }
}


