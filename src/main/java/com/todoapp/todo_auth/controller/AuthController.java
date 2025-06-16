package com.todoapp.todo_auth.controller;

import com.todoapp.todo_auth.domain.dto.AuthRequest;
import com.todoapp.todo_auth.domain.dto.AuthResponse;
import com.todoapp.todo_auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest authRequest){
        return ResponseEntity.ok(authService.register(authRequest));

    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }}
