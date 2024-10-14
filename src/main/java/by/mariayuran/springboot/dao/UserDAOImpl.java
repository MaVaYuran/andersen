package by.mariayuran.springboot.dao;

import by.mariayuran.springboot.entity.Ticket;
import by.mariayuran.springboot.entity.User;
import by.mariayuran.springboot.entity.UserStatus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
    private final SessionFactory sessionFactory;

    private final TicketDAO ticketDAO;

    @Value("${app.allowUserCreateAndUpdateTicket}")
    private boolean allowUserCreateAndUpdateTicket;


    public UserDAOImpl(SessionFactory sessionFactory, TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;

        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void save(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.save(user);
        }
    }

    @Override
    public User getUser(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(User.class, id);
        }
    }

    @Override
    public boolean delete(int id) {
        try (Session session = sessionFactory.openSession()) {
            User user;
            user = session.get(User.class, id);
            if (user == null) {
                return false;
            }
            session.delete(user);
        }
        return true;
    }
@Override
     public void activateUserAndUpdateTicket(Integer userId, Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            if (!allowUserCreateAndUpdateTicket) {
                throw new IllegalStateException("Updating user and creating ticket is disabled");
            }
            User user = session.get(User.class, userId);
            if (user == null) {
                throw new RuntimeException("User not found");
            }
            user.setStatus(UserStatus.ACTIVATED);
            session.save(user);
            ticketDAO.save(ticket);
        }
    }
}



