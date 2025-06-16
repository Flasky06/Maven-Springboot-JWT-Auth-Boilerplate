package com.todoapp.todo_auth.config;

import com.todoapp.todo_auth.domain.entity.User;
import com.todoapp.todo_auth.domain.model.Role;
import com.todoapp.todo_auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = User.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("admin123"))
                    .role(Role.ROLE_ADMIN)
                    .enabled(true)
                    .build();

            userRepository.save(admin);
            System.out.println("Admin user seeded with username='admin' and password='admin123'");
        } else {
            System.out.println("Admin user already exists. Skipping seeding.");
        }
    }
}
