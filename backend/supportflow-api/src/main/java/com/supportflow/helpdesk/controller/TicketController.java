package com.supportflow.helpdesk.controller;

import com.supportflow.helpdesk.dto.request.TicketRequestDTO;
import com.supportflow.helpdesk.dto.response.TicketResponseDTO;
import com.supportflow.helpdesk.service.TicketService;
import com.supportflow.helpdesk.dto.request.UpdateTicketStatusDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;



@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('CLIENT', 'ADMIN', 'TECHNICIAN')")
    @ResponseStatus(HttpStatus.CREATED)
    public TicketResponseDTO createTicket(@Valid @RequestBody TicketRequestDTO dto, Authentication authentication) {
        return ticketService.create(dto, authentication.getName());
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'TECHNICIAN', 'CLIENT')")
    public List<TicketResponseDTO> findAll() {
        return ticketService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'TECHNICIAN', 'CLIENT')")
    public TicketResponseDTO findById(@PathVariable Long id) {
        return ticketService.findById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        ticketService.delete(id);
    }

    @PutMapping("/{ticketId}/assign/{technicianId}")
    @PreAuthorize("hasRole('ADMIN')")
    public TicketResponseDTO assignTechnician(@PathVariable Long ticketId, @PathVariable Long technicianId) {

        return ticketService.assignTechnician(ticketId, technicianId);

    }

    @PatchMapping("/{id}/status")
    @PreAuthorize("hasAnyRole('ADMIN', 'TECHNICIAN')")
    public TicketResponseDTO updateStatus(
            @PathVariable Long id,
            @RequestBody UpdateTicketStatusDTO dto
    ) {
        return ticketService.updateStatus(id, dto);
    }     
    
}
