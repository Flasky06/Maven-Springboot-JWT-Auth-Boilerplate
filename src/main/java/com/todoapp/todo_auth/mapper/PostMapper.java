package com.todoapp.todo_auth.mapper;

import com.todoapp.todo_auth.domain.dto.PostDto;
import com.todoapp.todo_auth.domain.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CommentMapper.class})
public interface PostMapper {

    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "category.id", target = "categoryId")
    PostDto toDto(Post post);

    // For toEntity you can still ignore category, user and comments
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "comments", ignore = true)
    Post toEntity(PostDto dto);
}


