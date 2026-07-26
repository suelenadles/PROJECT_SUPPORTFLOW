package com.supportflow.helpdesk.repository;

import com.supportflow.helpdesk.domain.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    
}
