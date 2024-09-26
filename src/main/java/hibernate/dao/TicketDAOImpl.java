package hibernate.dao;

import homework.TicketType;
import hibernate.entity.Ticket;
import org.hibernate.HibernateException;
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

        try (Session session = sessionFactory.openSession()) {
            Integer savedId;
            Transaction transaction = session.beginTransaction();
            savedId = (Integer) session.save(ticket);
            transaction.commit();
            return savedId;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Ticket getTicket(int id) {

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            return session.get(Ticket.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Ticket> getUserTickets(int userId) {

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();//???
            return session.createQuery("from Ticket where userId = :userId", Ticket.class)
                    .setParameter("userId", userId)
                    .getResultList();

        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateTicketType(int id, TicketType newTicketType) {

        try (Session session = sessionFactory.openSession()) {
            Ticket ticket;
            ticket = session.get(Ticket.class, id);
            if (ticket != null) {
                ticket.setTicketType(newTicketType);
                Transaction transaction = session.beginTransaction();
                session.update(ticket);
                transaction.commit();
            } else {
                System.out.println("Ticket not found");
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
