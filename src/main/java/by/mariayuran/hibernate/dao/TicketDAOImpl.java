package by.mariayuran.hibernate.dao;


import by.mariayuran.hibernate.entity.Ticket;
import by.mariayuran.homework.TicketType;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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

            Transaction transaction = session.beginTransaction();
            Integer savedId = (Integer) session.save(ticket);
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
            Ticket ticket = session.get(Ticket.class, id);
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