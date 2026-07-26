package com.supportflow.helpdesk.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CommentRequestDTO(

        @NotBlank(message = "Message is required")
        String message,

        @NotNull(message = "Ticket id is required")
        Long ticketId,

        @NotNull(message = "Author id is required")
        Long authorId

) {
}
