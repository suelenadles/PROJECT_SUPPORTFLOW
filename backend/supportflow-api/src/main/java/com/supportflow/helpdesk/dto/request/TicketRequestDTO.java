package com.supportflow.helpdesk.dto.request;

import com.supportflow.helpdesk.domain.enums.TicketPriority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TicketRequestDTO (

    @NotBlank(message = "Title is required")
    String title,

    @NotBlank(message = "Description is required")
    String description,

    @NotNull(message = "Priority is required")
    TicketPriority priority,

    @NotNull(message = "Category is required")
    Long categoryId

) {
    
}
