package com.supportflow.helpdesk.service;

import com.supportflow.helpdesk.domain.entity.Attachment;
import com.supportflow.helpdesk.domain.entity.Ticket;
import com.supportflow.helpdesk.dto.request.AttachmentRequestDTO;
import com.supportflow.helpdesk.dto.response.AttachmentResponseDTO;
import com.supportflow.helpdesk.exception.ResourceNotFoundException;
import com.supportflow.helpdesk.mapper.AttachmentMapper;
import com.supportflow.helpdesk.repository.AttachmentRepository;
import com.supportflow.helpdesk.repository.TicketRepository;
import org.springframework.stereotype.Service;

@Service
public class AttachmentService {

    private final AttachmentRepository attachmentRepository;
    private final TicketRepository ticketRepository;


    public AttachmentService(
            AttachmentRepository attachmentRepository,
            TicketRepository ticketRepository
    ) {
        this.attachmentRepository = attachmentRepository;
        this.ticketRepository = ticketRepository;
    }


    public AttachmentResponseDTO create(AttachmentRequestDTO dto) {

        Ticket ticket = ticketRepository.findById(dto.ticketId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Ticket not found")
                );


        Attachment attachment = AttachmentMapper.toEntity(dto);

        attachment.setTicket(ticket);

        Attachment saved = attachmentRepository.save(attachment);

        return AttachmentMapper.toResponseDTO(saved);
    }
}