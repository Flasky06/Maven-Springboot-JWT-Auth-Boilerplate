package com.todoapp.todo_auth.util;

import com.todoapp.todo_auth.domain.entity.User;
import com.todoapp.todo_auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CurrentUserUtil {

    private final UserRepository userRepository;

    public static User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return SpringContext.getBean(UserRepository.class)
                .findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
