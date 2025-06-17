package com.todoapp.todo_auth.service;

import com.todoapp.todo_auth.domain.dto.CommentDto;
import com.todoapp.todo_auth.domain.dto.PostDto;
import com.todoapp.todo_auth.domain.entity.User;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    List<CommentDto> getAllComments();

    CommentDto createComment(CommentDto commentDto, User user);

    CommentDto getCommentById(UUID commentId);

    CommentDto updatePost(UUID commentId, CommentDto commentDto, User user);

    void deleteComment(UUID commentId);

    List<CommentDto> getCommentsByPost(UUID commentId);


}
