package com.todoapp.todo_auth.service;

import com.todoapp.todo_auth.domain.dto.CreateUserRequest;
import com.todoapp.todo_auth.domain.dto.UserDto;

public interface UserService {
    UserDto createUserByAdmin(CreateUserRequest request);

}
