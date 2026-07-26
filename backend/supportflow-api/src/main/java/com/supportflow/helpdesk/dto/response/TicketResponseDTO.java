package com.supportflow.helpdesk.dto.response;

import com.supportflow.helpdesk.domain.enums.TicketPriority;
import com.supportflow.helpdesk.domain.enums.TicketStatus;

import java.time.LocalDateTime;

public record TicketResponseDTO (
    
    Long id,

    String title,

    String description,

    TicketPriority priority,

    TicketStatus status,

    String requester,

    String technican,

    String category,

    LocalDateTime createdAt

) {
    
}
