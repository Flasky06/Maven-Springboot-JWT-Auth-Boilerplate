package com.todoapp.todo_auth.service.impl;

import com.todoapp.todo_auth.domain.dto.PostDto;
import com.todoapp.todo_auth.domain.entity.Category;
import com.todoapp.todo_auth.domain.entity.Post;
import com.todoapp.todo_auth.domain.entity.User;
import com.todoapp.todo_auth.mapper.PostMapper;
import com.todoapp.todo_auth.repository.CategoryRepository;
import com.todoapp.todo_auth.repository.PostRepository;
import com.todoapp.todo_auth.service.PostService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public PostDto createPost(PostDto dto, User user) {
        Post post = postMapper.toEntity(dto);

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
        post.setCategory(category);

        post.setUser(user);

        post.setCreatedAt(LocalDateTime.now());

        return postMapper.toDto(postRepository.save(post));
    }



    @Override
    public List<PostDto> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getPostsByUser(User user) {
        return postRepository.findByUser(user)
                .stream()
                .map(postMapper::toDto)
                .collect(Collectors.toList());
    }



    @Override
    public PostDto getPostById(UUID postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("Post not found"));
        return postMapper.toDto(post);
    }

    @Override
    public PostDto updatePost(UUID postId, PostDto postDto, User user) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("Post not found"));

        if (!post.getUser().getId().equals(user.getId())) {
            throw new SecurityException("Unauthorized to update this post");
        }

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        Post updated = postRepository.save(post);
        return postMapper.toDto(updated);
    }

    @Override
    public void deletePost(UUID postId, User user) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("Post not found"));

        if (!post.getUser().getId().equals(user.getId())) {
            throw new SecurityException("Unauthorized to delete this post");
        }

        postRepository.delete(post);
    }

    @Override
    public List<PostDto> getPostsByCategory(UUID categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        return postRepository.findAll()
                .stream()
                .map(postMapper::toDto)
                .collect(Collectors.toList());
    }


}
