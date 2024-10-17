package by.mariayuran.springboot.service;

import by.mariayuran.springboot.entity.Ticket;
import by.mariayuran.springboot.repositories.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    public Ticket getTicket(int id) {
        return ticketRepository.findById(id).orElse(null);
    }

    public Ticket createTicket(Ticket ticket) {
        if (ticket.getUser() == null) {
            throw new RuntimeException("User must not be null");
        }
        return ticketRepository.save(ticket);
    }

    public Ticket updateTicket(int id, Ticket ticket) {
        if (ticketRepository.existsById(id)) {
            ticket.setId(id);
            return ticketRepository.save(ticket);
        }
        return null;
    }

    public boolean deleteTicket(int id) {
        if (ticketRepository.existsById(id)) {
            ticketRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
