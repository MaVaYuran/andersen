package by.mariayuran.springboot.service;

import by.mariayuran.springboot.entity.Ticket;
import by.mariayuran.springboot.repositories.TicketsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class TicketService {
    private final TicketsRepository ticketsRepository;

    public Ticket getTicket(int id) {
      return ticketsRepository.findById(id).orElse(null);
    }

}
