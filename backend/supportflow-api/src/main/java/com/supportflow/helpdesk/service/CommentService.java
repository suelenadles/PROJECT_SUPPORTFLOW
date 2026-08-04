package com.supportflow.helpdesk.service;

import com.supportflow.helpdesk.domain.entity.Comment;
import com.supportflow.helpdesk.domain.entity.Ticket;
import com.supportflow.helpdesk.domain.entity.User;
import com.supportflow.helpdesk.dto.request.CommentRequestDTO;
import com.supportflow.helpdesk.dto.response.CommentResponseDTO;
import com.supportflow.helpdesk.exception.ResourceNotFoundException;
import com.supportflow.helpdesk.mapper.CommentMapper;
import com.supportflow.helpdesk.repository.CommentRepository;
import com.supportflow.helpdesk.repository.TicketRepository;
import com.supportflow.helpdesk.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;


    public CommentService(
            CommentRepository commentRepository,
            TicketRepository ticketRepository,
            UserRepository userRepository
    ) {
        this.commentRepository = commentRepository;
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }


    public CommentResponseDTO create(CommentRequestDTO dto) {

        Ticket ticket = ticketRepository.findById(dto.ticketId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Ticket not found with id: " + dto.ticketId()
                        ));


        User author = userRepository.findById(dto.authorId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with id: " + dto.authorId()
                        ));


        Comment comment = new Comment();

        comment.setMessage(dto.message());
        comment.setTicket(ticket);
        comment.setAuthor(author);
        comment.setCreatedAt(LocalDateTime.now());


        Comment savedComment = commentRepository.save(comment);


        return CommentMapper.toResponseDTO(savedComment);
    }

    public List<CommentResponseDTO> findByTicketId(Long ticketId) {

        ticketRepository.findById(ticketId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Ticket not found"
                        ));
        return commentRepository.findByTicketId(ticketId)
                .stream()
                .map(CommentMapper::toResponseDTO)
                .toList();
    }
}