package by.mariayuran.hibernate.dao;

import by.mariayuran.homework.TicketType;
import by.mariayuran.hibernate.entity.Ticket;

import java.util.List;

public interface TicketDAO {
    Integer save(Ticket ticket);
    Ticket getTicket(int id);
    List<Ticket> getUserTickets(int userId);
    void updateTicketType(int id, TicketType newTicketType);
}
