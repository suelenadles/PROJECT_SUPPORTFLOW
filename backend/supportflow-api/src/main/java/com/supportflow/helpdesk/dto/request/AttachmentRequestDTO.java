package com.supportflow.helpdesk.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AttachmentRequestDTO(

        @NotBlank(message = "File name is required")
        String fileName,

        @NotBlank(message = "File path is required")
        String filePath,

        @NotBlank(message = "Content type is required")
        String contentType,

        @NotNull(message = "Ticket id is required")
        Long ticketId

) {
}