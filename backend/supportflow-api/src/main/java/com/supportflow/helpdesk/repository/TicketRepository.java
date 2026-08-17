package com.supportflow.helpdesk.repository;

import com.supportflow.helpdesk.domain.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    
    List<Ticket> findByRequesterId(Long requesterId);

    List<Ticket> findByAssignedTechnicianId(Long technicianId);
}
