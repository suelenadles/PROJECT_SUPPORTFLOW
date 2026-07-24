package com.supportflow.helpdesk.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "attachments")
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String filePath;

    @Column(nullable = false)
    private String contentType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    private LocalDateTime createdAt;
}
