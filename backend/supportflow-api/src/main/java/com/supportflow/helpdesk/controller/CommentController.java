package com.supportflow.helpdesk.controller;

import com.supportflow.helpdesk.dto.request.CommentRequestDTO;
import com.supportflow.helpdesk.dto.response.CommentResponseDTO;
import com.supportflow.helpdesk.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;


    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentResponseDTO create(
            @Valid @RequestBody CommentRequestDTO dto
    ) {
        return commentService.create(dto);
    }

    @GetMapping("/ticket/{ticketId}")
    public List<CommentResponseDTO> findByTicketId(
            @PathVariable Long ticketId
    ) {
        return commentService.findByTicketId(ticketId);
    }
}