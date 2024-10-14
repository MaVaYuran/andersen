package by.mariayuran.springboot.dao;


import by.mariayuran.springboot.entity.Ticket;
import by.mariayuran.homework.TicketType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class TicketDAOImpl implements TicketDAO {
    private final SessionFactory sessionFactory;

    public TicketDAOImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    public void save(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            session.save(ticket);
        }
    }

    @Override
    public Ticket getTicket(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Ticket.class, id);
        }
    }

    @Override
    public List<Ticket> getUserTickets(int userId) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Ticket where userId = :userId", Ticket.class)
                    .setParameter("userId", userId)
                    .getResultList();

        }
    }

    @Override
    public void updateTicketType(int id, TicketType newTicketType) {
        try (Session session = sessionFactory.openSession()) {
            Ticket ticket = session.get(Ticket.class, id);
            if (ticket != null) {
                ticket.setTicketType(newTicketType);
                session.update(ticket);
            } else {
                System.out.println("Ticket not found");
            }
        }
    }
}
