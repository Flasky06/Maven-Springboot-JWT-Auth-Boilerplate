package com.todoapp.todo_auth.service;

import com.todoapp.todo_auth.domain.dto.CommentDto;
import com.todoapp.todo_auth.domain.dto.PostDto;
import com.todoapp.todo_auth.domain.entity.Post;
import com.todoapp.todo_auth.domain.entity.User;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    List<CommentDto> getAllComments();

    CommentDto createComment(CommentDto commentDto, User user, Post post);

    CommentDto getCommentById(UUID commentId);

    CommentDto updateComment(UUID commentId, CommentDto commentDto, User user);

    void deleteComment(UUID commentId, User user);


}
