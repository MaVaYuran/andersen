package jdbc.dao;

import homework.TicketType;
import jdbc.pojo.Ticket;

import java.util.List;

public interface TicketDAO {
    Ticket save(Ticket ticket);
    Ticket getTicket(int id);
    List<Ticket> getUserTickets(int userId);
    void updateTicketType(int id, TicketType newTicketType);
}
