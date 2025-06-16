package com.todoapp.todo_auth.service;

import com.todoapp.todo_auth.domain.dto.AuthRequest;
import com.todoapp.todo_auth.domain.dto.AuthResponse;

public interface AuthService {
    AuthResponse register(AuthRequest request);
    AuthResponse login(AuthRequest request);
}
