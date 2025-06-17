package com.todoapp.todo_auth.mapper;

import com.todoapp.todo_auth.domain.dto.PostDto;
import com.todoapp.todo_auth.domain.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "category.id", target = "categoryId")
    PostDto toDto(Post post);

    @Mapping(target = "category", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "comments", ignore = true)
    Post toEntity(PostDto dto);
}


