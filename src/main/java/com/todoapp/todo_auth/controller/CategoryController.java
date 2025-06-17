package com.todoapp.todo_auth.controller;

import com.todoapp.todo_auth.domain.dto.CategoryDto;
import com.todoapp.todo_auth.domain.entity.Category;
import com.todoapp.todo_auth.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.createCategory(categoryDto));
    }

    @GetMapping
    public  ResponseEntity<List<CategoryDto>> getAllCategories(){
        return  ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{categoryId}")
    public  ResponseEntity<CategoryDto> getCategoryById(@PathVariable UUID categoryId){
        return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
    }

    @PutMapping("/{categoryId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public  ResponseEntity<CategoryDto> getCategoryById(
            @PathVariable UUID categoryId ,@RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
    }

    @DeleteMapping("/{categoryId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> deletePost(@PathVariable UUID categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.noContent().build();


    }


    }
