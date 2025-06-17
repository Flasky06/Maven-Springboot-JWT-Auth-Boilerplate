package com.todoapp.todo_auth.repository;

import com.todoapp.todo_auth.domain.entity.Category;
import com.todoapp.todo_auth.domain.entity.Post;
import com.todoapp.todo_auth.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

}
