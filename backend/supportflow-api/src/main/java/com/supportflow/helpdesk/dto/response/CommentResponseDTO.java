package com.supportflow.helpdesk.dto.response;

import java.time.LocalDateTime;

public record CommentResponseDTO(

        Long id,
        String message,
        String author,
        LocalDateTime createdAt

) {
}