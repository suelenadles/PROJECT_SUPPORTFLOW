package com.supportflow.helpdesk.domain.entity;

import com.supportflow.helpdesk.domain.enums.TicketPriority;
import com.supportflow.helpdesk.domain.enums.TicketStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @Enumerated(EnumType.STRING)
    private TicketPriority priority;

    @ManyToOne
    @JoinColumn(name = "requester_id", nullable = false)
    private User requester;

    @ManyToOne
    @JoinColumn(name = "assigned_technician_id")
    private User assignedTechnician;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
    
    private LocalDateTime closedAt;

    public Ticket() {
    }

    public Ticket(Long id, String title, String description, TicketStatus status, TicketPriority priority, User requester, User assignedTechnician, Category category, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime closedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.requester = requester;
        this.assignedTechnician = assignedTechnician;
        this.category = category;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.closedAt = closedAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TicketPriority getPriority() {
        return priority;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public User getRequester() {
        return requester;
    }

    public void setPriority(TicketPriority priority) {
        this.priority = priority;
    }

    public User getAssignedTechnician() {
        return assignedTechnician;
    }

    public void setRequester(User requester) {
        this.requester = requester;
    }

    public Category getCategory() {
        return category;
    }

    public void setAssignedTechnician(User assignedTechnician) {
        this.assignedTechnician = assignedTechnician;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getClosedAt() {
        return closedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
