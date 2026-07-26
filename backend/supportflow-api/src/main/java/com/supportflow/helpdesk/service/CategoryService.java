package com.supportflow.helpdesk.service;

import com.supportflow.helpdesk.domain.entity.Category;
import com.supportflow.helpdesk.dto.request.CategoryRequestDTO;
import com.supportflow.helpdesk.exception.ResourceNotFoundException;
import com.supportflow.helpdesk.repository.CategoryRepository;
import com.supportflow.helpdesk.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category create(CategoryRequestDTO dto) {
        Category category = CategoryMapper.toEntity(dto);
        return categoryRepository.save(category);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findAllById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    public void delete(Long id) {
        Category category = findAllById(id);
        categoryRepository.delete(category);
    }
    
}
