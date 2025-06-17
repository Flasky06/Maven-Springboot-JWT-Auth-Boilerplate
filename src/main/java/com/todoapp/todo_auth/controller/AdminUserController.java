package com.todoapp.todo_auth.controller;

import com.todoapp.todo_auth.domain.dto.CreateUserRequest;
import com.todoapp.todo_auth.domain.dto.UserDto;
import com.todoapp.todo_auth.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/users")
@RequiredArgsConstructor
public class AdminUserController {

    private final UserService userService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "User creation by Admin")
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserRequest request) {
        return ResponseEntity.ok(userService.createUserByAdmin(request));
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "admin GET all users")
    public ResponseEntity<List<UserDto>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

}
