package com.todoapp.todo_auth.mapper;

import com.todoapp.todo_auth.domain.dto.CategoryDto;
import com.todoapp.todo_auth.domain.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto toDTO(Category category);

    Category toEntity(CategoryDto dto);
}
