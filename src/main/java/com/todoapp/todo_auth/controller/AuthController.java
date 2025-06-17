package com.todoapp.todo_auth.controller;

import com.todoapp.todo_auth.domain.dto.AuthRequest;
import com.todoapp.todo_auth.domain.dto.AuthResponse;
import com.todoapp.todo_auth.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    @Operation(summary = "User Register")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest authRequest){
        return ResponseEntity.ok(authService.register(authRequest));

    }

    @PostMapping("/login")
    @Operation(summary = "User Login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }}
