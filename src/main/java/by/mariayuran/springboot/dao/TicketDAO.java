package by.mariayuran.springboot.dao;

import by.mariayuran.homework.TicketType;
import by.mariayuran.springboot.entity.Ticket;

import java.util.List;

public interface TicketDAO {
    void save(Ticket ticket);
    Ticket getTicket(int id);
    List<Ticket> getUserTickets(int userId);
    void updateTicketType(int id, TicketType newTicketType);
}
