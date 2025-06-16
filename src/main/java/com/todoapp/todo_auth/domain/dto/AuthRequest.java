package com.todoapp.todo_auth.domain.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
