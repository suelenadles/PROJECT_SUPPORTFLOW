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

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Attachment() {
    }

    public Attachment(Long id, String fileName, String filePath, String contentType, Ticket ticket, LocalDateTime createdAt) {
        this.id = id;
        this.fileName = fileName;
        this.filePath = filePath;
        this.contentType = contentType;
        this.ticket = ticket;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
}

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
