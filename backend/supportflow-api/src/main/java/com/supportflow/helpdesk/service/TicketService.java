package com.supportflow.helpdesk.service;

import com.supportflow.helpdesk.domain.entity.Category;
import com.supportflow.helpdesk.domain.entity.Ticket;
import com.supportflow.helpdesk.domain.entity.User;
import com.supportflow.helpdesk.domain.enums.TicketStatus;
import com.supportflow.helpdesk.dto.request.TicketRequestDTO;
import com.supportflow.helpdesk.dto.response.TicketResponseDTO;
import com.supportflow.helpdesk.exception.ResourceNotFoundException;
import com.supportflow.helpdesk.mapper.TicketMapper;
import com.supportflow.helpdesk.repository.CategoryRepository;
import com.supportflow.helpdesk.repository.TicketRepository;
import com.supportflow.helpdesk.repository.UserRepository;
import com.supportflow.helpdesk.dto.request.UpdateTicketStatusDTO;
import com.supportflow.helpdesk.exception.InvalidTicketStatusExcepition;
import com.supportflow.helpdesk.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.supportflow.helpdesk.domain.enums.UserRole;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public TicketService(TicketRepository ticketRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    public TicketResponseDTO create(TicketRequestDTO dto) {
        
        User requester = userRepository.findById(dto.requesterId())
                .orElseThrow(() -> new ResourceNotFoundException("Requester not found with id: " + dto.requesterId()));
        
        Category category = categoryRepository.findById(dto.categoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + dto.categoryId()));       

        Ticket ticket = TicketMapper.toEntity(dto);

        ticket.setRequester(requester);
        ticket.setCategory(category);

        ticket.setStatus(TicketStatus.OPEN);
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setUpdatedAt(LocalDateTime.now());

        Ticket savedTicket = ticketRepository.save(ticket);
        return TicketMapper.toResponseDTO(savedTicket);
    }

    public TicketResponseDTO assignTechnician(Long ticketId, Long technicianId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id: " + ticketId));

        User technician = userRepository.findById(technicianId)
                .orElseThrow(() -> new ResourceNotFoundException("Technician not found with id: " + technicianId));

        if (technician.getRole() != UserRole.TECHNICIAN) {
            throw new RuntimeException("User is not a technician");
        }

        ticket.setAssignedTechnician(technician);
        ticket.setStatus(TicketStatus.IN_PROGRESS);
        ticket.setUpdatedAt(LocalDateTime.now());

        Ticket updatedTicket = ticketRepository.save(ticket);
        return TicketMapper.toResponseDTO(updatedTicket);
    }

    public List<TicketResponseDTO> findAll() {
        return ticketRepository.findAll().stream()
                .map(TicketMapper::toResponseDTO)
                .toList();
    }
    
    public TicketResponseDTO findById(Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id: " + id));
        return TicketMapper.toResponseDTO(ticket);
    }

    public TicketResponseDTO updateStatus(
        Long ticketId,
        UpdateTicketStatusDTO dto
    ) {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id: " + ticketId));

        validateStatusTransition(ticket.getStatus(), dto.status());
        
        ticket.setStatus(dto.status());
        ticket.setUpdatedAt(LocalDateTime.now());

        if (dto.status() == TicketStatus.CLOSED) {
            ticket.setClosedAt(LocalDateTime.now());
        }

        Ticket updatedTicket = ticketRepository.save(ticket);
        return TicketMapper.toResponseDTO(updatedTicket);
    }

    private void validateStatusTransition(TicketStatus currentStatus, TicketStatus newStatus) {
        if (currentStatus == TicketStatus.CLOSED) {
            throw new InvalidTicketStatusExcepition("Closed tickets cannot be changed.");
        }

        if (currentStatus == TicketStatus.OPEN && newStatus == TicketStatus.CLOSED) {
            throw new InvalidTicketStatusExcepition("Cannot close an open ticket without assigning a technician.");
        }

        if (currentStatus == TicketStatus.IN_PROGRESS && newStatus == TicketStatus.OPEN) {
            throw new InvalidTicketStatusExcepition("Ticket must be in progress before closing.");
        }
    }

    public void delete(Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with id: " + id));
        ticketRepository.delete(ticket);
    }
}
