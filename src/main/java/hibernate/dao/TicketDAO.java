package hibernate.dao;

import homework.TicketType;
import hibernate.entity.Ticket;

import java.util.List;

public interface TicketDAO {
    Integer save(Ticket ticket);
    Ticket getTicket(int id);
    List<Ticket> getUserTickets(int userId);
    void updateTicketType(int id, TicketType newTicketType);
}
