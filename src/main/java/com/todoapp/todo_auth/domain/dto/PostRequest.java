package com.todoapp.todo_auth.domain.dto;

import lombok.Data;

@Data
public class PostRequest {
    private String title;
    private String content;
}
