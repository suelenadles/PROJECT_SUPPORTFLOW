package com.supportflow.helpdesk.repository;

import com.supportflow.helpdesk.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository <Comment, Long> {

    List<Comment> findByTicketId(Long ticketId);
    
}
