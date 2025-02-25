package com.ticket.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.ticket.entity.Ticket;
import com.ticket.enums.Category;
import com.ticket.enums.Priority;
import com.ticket.repo.TicketRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;

public class TicketServiceTest {

    @Mock
    private TicketRepo ticketRepository;

    @InjectMocks
    private TicketService ticketService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTicket() {
        Ticket ticket = new Ticket("Network Issue", "Internet down", Priority.valueOf("HIGH"), Category.valueOf("Network"));
        when(ticketRepository.save(any(Ticket.class))).thenReturn(ticket);

        Ticket savedTicket = ticketService.createTicket(ticket);

        assertNotNull(savedTicket);
        assertEquals("Network Issue", savedTicket.getTitle());
    }

    @Test
    void testFindTicketById() {
        Ticket ticket = new Ticket("Network Issue", "Internet down", Priority.valueOf("HIGH"), Category.valueOf("Network"));
        when(ticketRepository.findById(1L)).thenReturn(Optional.of(ticket));

        Optional<Ticket> foundTicket = ticketService.getTicketById(1L);
        assertTrue(foundTicket.isPresent());
        assertEquals("Software Bug", foundTicket.get().getTitle());
    }
}
