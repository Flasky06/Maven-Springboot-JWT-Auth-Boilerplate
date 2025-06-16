package com.todoapp.todo_auth.domain.dto;

import com.todoapp.todo_auth.domain.model.Role;

public record CreateUserRequest(
        String username,
        Role role,
        boolean enabled
) {}

