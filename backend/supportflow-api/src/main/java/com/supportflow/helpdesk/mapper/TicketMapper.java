package com.supportflow.helpdesk.mapper;

import com.supportflow.helpdesk.domain.entity.Ticket;
import com.supportflow.helpdesk.dto.request.TicketRequestDTO;
import com.supportflow.helpdesk.dto.response.TicketResponseDTO;

public class TicketMapper {

    private TicketMapper() {
    }

    public static Ticket toEntity(TicketRequestDTO dto) {

        Ticket ticket = new Ticket();

        ticket.setTitle(dto.title());
        ticket.setDescription(dto.description());
        ticket.setPriority(dto.priority());

        return ticket;
    }

    public static TicketResponseDTO toResponseDTO(Ticket ticket) {

        return new TicketResponseDTO(
                ticket.getId(),
                ticket.getTitle(),
                ticket.getDescription(),
                ticket.getPriority(),
                ticket.getStatus(),
                ticket.getRequester().getName(),
                ticket.getAssignedTechnician() != null ? ticket.getAssignedTechnician().getName() : null,
                ticket.getCategory().getName(),
                ticket.getCreatedAt()
        );
    }
    
}
