package com.todoapp.todo_auth.service.impl;

import com.todoapp.todo_auth.domain.dto.CommentDto;
import com.todoapp.todo_auth.domain.entity.Comment;
import com.todoapp.todo_auth.domain.entity.Post;
import com.todoapp.todo_auth.domain.entity.User;
import com.todoapp.todo_auth.mapper.CommentMapper;
import com.todoapp.todo_auth.repository.CommentRepository;
import com.todoapp.todo_auth.service.CommentService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public CommentDto createComment(CommentDto commentDto, User user, Post post) {
        Comment comment = commentMapper.toEntity(commentDto);
        comment.setUser(user);
        comment.setPost(post);
        comment.setCreatedAt(LocalDateTime.now());
        return commentMapper.toDto(commentRepository.save(comment));
    }

    @Override
    public CommentDto getCommentById(UUID commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new EntityNotFoundException("Comment not found"));

        return commentMapper.toDto(comment);
    }

    @Override
    @Transactional
    public CommentDto updateComment(UUID commentId, CommentDto commentDto, User user) {
        if (commentId == null || commentDto == null || user == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new EntityNotFoundException("Comment not found"));

        // Check if user is authorized to update the comment
        if (!comment.getUser().getId().equals(user.getId())) {
            throw new SecurityException("User not authorized to update this comment");
        }

        comment.setComment(commentDto.getComment());

        Comment updatedComment = commentRepository.save(comment);
        return commentMapper.toDto(updatedComment);
    }

    @Override
    @Transactional
    public void deleteComment(UUID commentId, User user) {
        if (commentId == null) {
            throw new IllegalArgumentException("Comment ID cannot be null");
        }
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new EntityNotFoundException("Comment not found"));

        // Check if user is authorized to delete the comment
        if (!comment.getUser().getId().equals(user.getId())) {
            throw new SecurityException("User not authorized to delete this comment");
        }

        commentRepository.delete(comment);
    }

}
