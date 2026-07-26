package com.supportflow.helpdesk.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AttachmentRequestDTO(

        @NotBlank(message = "File name is required")
        String fileName,

        @NotBlank(message = "File type is required")
        String fileType,

        @NotBlank(message = "File url is required")
        String fileUrl,

        @NotNull(message = "Ticket id is required")
        Long ticketId

) {
}