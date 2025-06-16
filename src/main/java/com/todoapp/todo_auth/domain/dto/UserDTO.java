package com.todoapp.todo_auth.domain.dto;

import com.todoapp.todo_auth.domain.model.Role;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private UUID id;
    private String username;
    private Role role;
    private boolean enabled;
}

