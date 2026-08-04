package com.supportflow.helpdesk.dto.request;

import com.supportflow.helpdesk.domain.enums.TicketStatus;
import jakarta.validation.constraints.NotNull;

public record UpdateTicketStatusDTO(
    @NotNull(message = "Status is required")
    TicketStatus status
) {
    
}
