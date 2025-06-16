package com.todoapp.todo_auth.service;

import com.todoapp.todo_auth.domain.dto.PostDto;
import com.todoapp.todo_auth.domain.entity.User;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.UUID;

public interface PostService {
    PostDto createPost(PostDto postDto, User user);
    List<PostDto> getAllPosts();
    List<PostDto> getPostsByUser(User user);
    PostDto getPostById(UUID postId);
    PostDto updatePost(UUID postId, PostDto postDto, User user);
    void deletePost(UUID postId, User user);
}
