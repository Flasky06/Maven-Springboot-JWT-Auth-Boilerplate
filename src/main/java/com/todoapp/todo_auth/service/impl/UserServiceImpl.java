package com.todoapp.todo_auth.service.impl;

import com.todoapp.todo_auth.domain.dto.CreateUserRequest;
import com.todoapp.todo_auth.domain.dto.UserDto;
import com.todoapp.todo_auth.domain.entity.User;
import com.todoapp.todo_auth.mapper.UserMapper;
import com.todoapp.todo_auth.repository.UserRepository;
import com.todoapp.todo_auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public UserDto createUserByAdmin(CreateUserRequest request) {
        User user = User.builder()
                .username(request.username())
                .password(passwordEncoder.encode(request.username()))
                .role(request.role())
                .enabled(request.enabled())
                .build();

        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

}
