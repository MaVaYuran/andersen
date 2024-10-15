package by.mariayuran.springboot.service;

import by.mariayuran.springboot.entity.Ticket;
import by.mariayuran.springboot.repositories.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    public Ticket getTicket(int id) {
      return ticketRepository.findById(id).orElse(null);
    }

}
