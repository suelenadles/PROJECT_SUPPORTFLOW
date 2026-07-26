package com.supportflow.helpdesk.controller;

import com.supportflow.helpdesk.dto.request.AttachmentRequestDTO;
import com.supportflow.helpdesk.dto.response.AttachmentResponseDTO;
import com.supportflow.helpdesk.service.AttachmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attachments")
public class AttachmentController {

    private final AttachmentService attachmentService;


    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AttachmentResponseDTO create(
            @Valid @RequestBody AttachmentRequestDTO dto
    ) {
        return attachmentService.create(dto);
    }
}