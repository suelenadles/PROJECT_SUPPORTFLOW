package com.supportflow.helpdesk.repository;

import com.supportflow.helpdesk.domain.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}