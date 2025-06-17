package com.todoapp.todo_auth.service;

import com.todoapp.todo_auth.domain.dto.CategoryDto;
import com.todoapp.todo_auth.domain.dto.CreateCategoryRequest;
import com.todoapp.todo_auth.domain.entity.Category;
import com.todoapp.todo_auth.domain.entity.User;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto request);
    List<CategoryDto> getAllCategories();
    CategoryDto getCategoryById(UUID categoryId);
    CategoryDto updateCategory(UUID categoryId, CategoryDto categoryDto );
    void deleteCategory(UUID categoryId);


}
