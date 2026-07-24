package com.supportflow.helpdesk.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Comment() {
    }

    public Comment(Long id, String message, Ticket ticket, User author, LocalDateTime createdAt) {
        this.id = id;
        this.message = message;
        this.ticket = ticket;
        this.author = author;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }
    
    public String getMessage() {
        return message;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public User getAuthor() {
        return author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
