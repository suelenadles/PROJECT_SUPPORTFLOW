package com.supportflow.helpdesk.controller;

import com.supportflow.helpdesk.domain.entity.Category;
import com.supportflow.helpdesk.service.CategoryService;
import com.supportflow.helpdesk.dto.request.CategoryRequestDTO;
import com.supportflow.helpdesk.dto.response.CategoryResponseDTO;
import com.supportflow.helpdesk.mapper.CategoryMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponseDTO create(@Valid @RequestBody CategoryRequestDTO dto) {
        Category category = categoryService.create(dto);
        return CategoryMapper.toResponseDTO(category);
    }

    @GetMapping
    public List<CategoryResponseDTO> findAll() {
        return categoryService.findAll().stream()
                .map(CategoryMapper::toResponseDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public CategoryResponseDTO findById(@PathVariable Long id) {
        Category category = categoryService.findAllById(id);
        return CategoryMapper.toResponseDTO(category);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }
    
    
}
