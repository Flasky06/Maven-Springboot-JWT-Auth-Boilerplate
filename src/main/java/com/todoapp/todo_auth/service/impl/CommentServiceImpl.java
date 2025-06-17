package com.todoapp.todo_auth.service.impl;

import com.todoapp.todo_auth.domain.dto.CommentDto;
import com.todoapp.todo_auth.domain.entity.User;
import com.todoapp.todo_auth.mapper.CommentMapper;
import com.todoapp.todo_auth.repository.CommentRepository;
import com.todoapp.todo_auth.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;


    @Override
    public List<CommentDto> getAllComments() {
        return commentRepository.findAll()
                .stream()
                .map(commentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, User user) {
        return null;
    }

    @Override
    public CommentDto getCommentById(UUID commentId) {
        return null;
    }

    @Override
    public CommentDto updatePost(UUID commentId, CommentDto commentDto, User user) {
        return null;
    }

    @Override
    public void deleteComment(UUID commentId) {

    }

    @Override
    public List<CommentDto> getCommentsByPost(UUID commentId) {
        return null;
    }
}
