package com.supportflow.helpdesk.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CategoryRequestDTO(

    @NotBlank(message = "Category name cannot be blank")
    String name,

    @NotBlank(message = "Description is required")
    String description
) {
    
}
