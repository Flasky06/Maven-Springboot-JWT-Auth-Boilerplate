package com.todoapp.todo_auth.domain.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class PostDto {
    private UUID id;
    private String title;
    private String content;
    private UUID categoryId;
    private String username;
    private List<CommentDto> comments;

}
