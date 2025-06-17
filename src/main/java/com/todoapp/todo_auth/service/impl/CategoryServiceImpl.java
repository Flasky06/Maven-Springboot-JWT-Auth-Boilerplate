package com.todoapp.todo_auth.service.impl;

import com.todoapp.todo_auth.domain.dto.CategoryDto;
import com.todoapp.todo_auth.domain.entity.Category;
import com.todoapp.todo_auth.domain.entity.User;
import com.todoapp.todo_auth.mapper.CategoryMapper;
import com.todoapp.todo_auth.repository.CategoryRepository;
import com.todoapp.todo_auth.service.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    @Override
    public CategoryDto createCategory(CategoryDto request) {
        Category category = categoryMapper.toEntity(request);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toDTO(savedCategory);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategoryById(UUID categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        return categoryMapper.toDTO(category);
    }

    @Override
    public CategoryDto updateCategory(UUID categoryId, CategoryDto categoryDto) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        category.setName(category.getName());
        Category updatedCategory = categoryRepository.save(category);

        return categoryMapper.toDTO(category);    }

    @Override
    public void deleteCategory(UUID categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));

        categoryRepository.delete(category);

    }


}
