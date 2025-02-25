package com.ticket.entity;

import com.ticket.enums.Category;
import com.ticket.enums.Priority;
import com.ticket.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
@Getter @Setter
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime creationDate = LocalDateTime.now();

    @Column(nullable = false)
    private String createdBy;

    public Ticket(String title, String description, Priority priority, Category category) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.category = category;
    }


    public void setStatus(Status status) {
        this.status = status;
    }
}
