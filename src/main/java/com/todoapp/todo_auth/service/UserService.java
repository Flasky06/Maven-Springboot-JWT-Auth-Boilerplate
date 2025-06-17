package com.todoapp.todo_auth.service;

import com.todoapp.todo_auth.domain.dto.CreateUserRequest;
import com.todoapp.todo_auth.domain.dto.PostDto;
import com.todoapp.todo_auth.domain.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUserByAdmin(CreateUserRequest request);
    List<UserDto> getAllUsers();


}
