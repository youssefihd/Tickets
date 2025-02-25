package com.ticket.controller;

import com.ticket.entity.Ticket;
import com.ticket.enums.Status;
import com.ticket.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        return ResponseEntity.ok(ticketService.createTicket(ticket));
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }


    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> updateTicketStatus(@PathVariable Long id, @RequestParam Status status) {
        ticketService.updateTicketStatus(id, status);
        return ResponseEntity.ok().build();
    }
}
