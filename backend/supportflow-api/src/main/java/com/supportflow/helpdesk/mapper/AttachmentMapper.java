package com.supportflow.helpdesk.mapper;

import com.supportflow.helpdesk.domain.entity.Attachment;
import com.supportflow.helpdesk.dto.request.AttachmentRequestDTO;
import com.supportflow.helpdesk.dto.response.AttachmentResponseDTO;

import java.time.LocalDateTime;

public class AttachmentMapper {

    private AttachmentMapper() {
    }


    public static Attachment toEntity(AttachmentRequestDTO dto) {

        Attachment attachment = new Attachment();

        attachment.setFileName(dto.fileName());
        attachment.setFilePath(dto.filePath());
        attachment.setContentType(dto.contentType());
        attachment.setCreatedAt(LocalDateTime.now());

        return attachment;
    }


    public static AttachmentResponseDTO toResponseDTO(Attachment attachment) {

        return new AttachmentResponseDTO(
                attachment.getId(),
                attachment.getFileName(),
                attachment.getFilePath(),
                attachment.getContentType(),
                attachment.getCreatedAt()
        );
    }
}