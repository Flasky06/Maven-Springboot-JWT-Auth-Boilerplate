package com.todoapp.todo_auth.mapper;

import com.todoapp.todo_auth.domain.dto.UserDto;
import com.todoapp.todo_auth.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto toDTO(User user);

    User toENTITY(UserDto userDTO);
}
