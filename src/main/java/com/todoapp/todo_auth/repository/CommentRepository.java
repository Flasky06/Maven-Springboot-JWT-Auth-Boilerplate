package com.todoapp.todo_auth.repository;

import com.todoapp.todo_auth.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
}
