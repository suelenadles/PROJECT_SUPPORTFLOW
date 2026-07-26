package com.supportflow.helpdesk.mapper;

import com.supportflow.helpdesk.domain.entity.Category;
import com.supportflow.helpdesk.dto.response.CategoryResponseDTO;
import com.supportflow.helpdesk.dto.request.CategoryRequestDTO;

import java.time.LocalDateTime;

public class CategoryMapper {

    private CategoryMapper (){

    }

    public static Category toEntity(CategoryRequestDTO dto) {
        
        Category category = new Category();

        category.setName(dto.name());
        category.setDescription(dto.description());
        category.setCreatedAt(LocalDateTime.now());

        return category;
    
    }

    public static CategoryResponseDTO toResponseDTO(Category category) {
        return new CategoryResponseDTO(
            category.getId(),
            category.getName(),
            category.getDescription()
        );
    }

}   
