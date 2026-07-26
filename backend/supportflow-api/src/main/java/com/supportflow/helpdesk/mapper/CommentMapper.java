package com.supportflow.helpdesk.mapper;

import com.supportflow.helpdesk.domain.entity.Comment;
import com.supportflow.helpdesk.dto.response.CommentResponseDTO;

public class CommentMapper {

    private CommentMapper() {
    }

    public static CommentResponseDTO toResponseDTO(Comment comment) {

        return new CommentResponseDTO(
                comment.getId(),
                comment.getMessage(),
                comment.getAuthor().getName(),
                comment.getCreatedAt()
        );
    }
}