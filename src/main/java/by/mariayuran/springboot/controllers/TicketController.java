package by.mariayuran.springboot.controllers;

import by.mariayuran.springboot.entity.Ticket;
import by.mariayuran.springboot.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;

    @GetMapping("/{id}")
    public Ticket getTicket(@PathVariable("id") int id) {
        return ticketService.getTicket(id);
    }
}
