package com.supportflow.helpdesk.dto.response;

import java.time.LocalDateTime;

public record AttachmentResponseDTO(

        Long id,
        String fileName,
        String filePath,
        String contentType,
        LocalDateTime createdAt

) {
}