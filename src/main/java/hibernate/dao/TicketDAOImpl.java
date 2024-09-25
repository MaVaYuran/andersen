package hibernate.dao;

import homework.TicketType;
import hibernate.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDAOImpl implements TicketDAO {
    private final SessionFactory sessionFactory;

    public TicketDAOImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }

    public Integer save(Ticket ticket) {
        Session session = null;
        Transaction transaction = null;
        Integer savedId;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            savedId = (Integer) session.save(ticket);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            if (session != null) session.close();
        }
        return savedId;
    }

    @Override
    public Ticket getTicket(int id) {
        Session session = null;
        Transaction transaction = null;
        Ticket ticket;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            ticket = session.get(Ticket.class, id);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);

        } finally {
            if (session != null) session.close();
        }
        return ticket;
    }

    @Override
    public List<Ticket> getUserTickets(int userId) {
        Session session = null;
        Transaction transaction = null;
        List<Ticket> userTickets;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            userTickets = session.createQuery("from Ticket where userId = :userId", Ticket.class)
                    .setParameter("userId", userId)
                    .getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);

        } finally {
            if (session != null) session.close();
        }
        return userTickets;
    }

    @Override
    public void updateTicketType(int id, TicketType newTicketType) {
        Session session = null;
        Transaction transaction = null;
        Ticket ticket;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            ticket = session.get(Ticket.class, id);
            if (ticket != null) {
                ticket.setTicketType(newTicketType);
                session.update(ticket);
                transaction.commit();
            }

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        }
        finally {
            if(session != null) session.close();
        }
    }
}
