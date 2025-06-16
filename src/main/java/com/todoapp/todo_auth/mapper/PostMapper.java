package com.todoapp.todo_auth.mapper;

import com.todoapp.todo_auth.domain.dto.PostDto;
import com.todoapp.todo_auth.domain.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(source = "user.username", target = "username")
    PostDto toDto(Post post);

    @Mapping(source = "username", target = "user.username")
    Post toEntity(PostDto dto);
}
