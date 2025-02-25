package com.ticket.repo;

import com.ticket.entity.TicketComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TicketCommentRepo extends JpaRepository<TicketComment, Long> {
    List<TicketComment> findByTicketId(Long ticketId);
}