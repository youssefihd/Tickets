package com.ticket.repo;

import com.ticket.entity.Ticket;
import com.ticket.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TicketRepo extends JpaRepository<Ticket, Long> {
    List<Ticket> findByCreatedBy(String createdBy);
    List<Ticket> findByStatus(Status status);
}