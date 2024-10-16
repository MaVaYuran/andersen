package by.mariayuran.springboot.service;

import by.mariayuran.homework.TicketType;
import by.mariayuran.springboot.entity.Ticket;
import by.mariayuran.springboot.entity.User;
import by.mariayuran.springboot.repositories.TicketRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TicketServiceTest {

    @Mock
    private TicketRepository ticketRepository;

    @InjectMocks
    @Autowired
    private TicketService ticketService;

    private Ticket ticket;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ticket = new Ticket();
        ticket.setUser(new User());
        ticket.setTicketType(TicketType.DAY);
        ticket.setCreationDate(LocalDate.now());
    }

    @Test
    void testCreateTicket_Positive() {
        when(ticketRepository.save(any(Ticket.class))).thenReturn(ticket);
        Ticket createdTicket = ticketService.createTicket(ticket);
        assertNotNull(createdTicket);
        assertEquals(ticket, createdTicket);
        verify(ticketRepository).save(ticket);
    }

    @Test
    void testCreateTicket_Negative() {
        when(ticketRepository.save(any(Ticket.class))).thenThrow(new RuntimeException("Error saving ticket"));
        Exception exception = assertThrows(RuntimeException.class, () -> {
            ticketService.createTicket(ticket);
        });
        assertEquals("Error saving ticket", exception.getMessage());
    }

    @Test
    void testCreateTicket_CornerCase() {
        ticket.setUser(null); // Assuming user is required
        Exception exception = assertThrows(RuntimeException.class, () -> {
            ticketService.createTicket(ticket);
        });
        assertEquals("User must not be null", exception.getMessage());
    }

    @Test
    void testGetTicket_Positive() {
        when(ticketRepository.findById(anyInt())).thenReturn(Optional.of(ticket));
        Ticket fetchedTicket = ticketService.getTicket(1);
        assertNotNull(fetchedTicket);
        assertEquals(ticket, fetchedTicket);
    }

    @Test
    void testGetTicket_Negative() {
        when(ticketRepository.findById(anyInt())).thenReturn(Optional.empty());
        Ticket fetchedTicket = ticketService.getTicket(1);
        assertNull(fetchedTicket);
    }

    @Test
    void testUpdateTicket_Positive() {
        ticket.setId(1);
        when(ticketRepository.existsById(1)).thenReturn(true);
        when(ticketRepository.save(ticket)).thenReturn(ticket);

        Ticket updatedTicket = ticketService.updateTicket(1, ticket);
        assertNotNull(updatedTicket);
        assertEquals(ticket, updatedTicket);
    }

    @Test
    void testUpdateTicket_Negative() {
        when(ticketRepository.existsById(1)).thenReturn(false);
        Ticket updatedTicket = ticketService.updateTicket(1, ticket);
        assertNull(updatedTicket);
    }

    @Test
    void testDeleteTicket_Positive() {
        when(ticketRepository.existsById(1)).thenReturn(true);
        boolean isDeleted = ticketService.deleteTicket(1);
        assertTrue(isDeleted);
        verify(ticketRepository).deleteById(1);
    }

    @Test
    void testDeleteTicket_Negative() {
        when(ticketRepository.existsById(1)).thenReturn(false);
        boolean isDeleted = ticketService.deleteTicket(1);
        assertFalse(isDeleted);
    }
}
