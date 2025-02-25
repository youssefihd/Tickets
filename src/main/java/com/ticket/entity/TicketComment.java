package com.ticket.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "ticket_comments")
@Data
public class TicketComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @Lob
    @Column(nullable = false)
    private String commentText;

    @Column(nullable = false)
    private String commentedBy;

    @Column(nullable = false)
    private LocalDateTime commentDate = LocalDateTime.now();
}
