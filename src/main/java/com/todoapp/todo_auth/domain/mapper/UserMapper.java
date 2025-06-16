package com.todoapp.todo_auth.domain.mapper;

import com.todoapp.todo_auth.domain.dto.UserDTO;
import com.todoapp.todo_auth.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO toDTO(User user);

    User toENTITY(UserDTO userDTO);
}
