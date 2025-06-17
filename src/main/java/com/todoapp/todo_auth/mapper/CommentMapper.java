package com.todoapp.todo_auth.mapper;

import com.todoapp.todo_auth.domain.dto.CommentDto;
import com.todoapp.todo_auth.domain.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(source = "user.username", target = "username")
    CommentDto toDto(Comment comment);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "post", ignore = true)
    Comment toEntity(CommentDto dto);
}
