package hibernate.dao;

import hibernate.entity.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class UserDAOImpl implements UserDAO {
    private final SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        if (sessionFactory == null) {
            throw new IllegalArgumentException("An argument sessionFactory cannot be null");
        }
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Integer save(User user) {
        Session session = null;
        Transaction transaction = null;
        Integer savedId;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            savedId = (Integer) session.save(user);
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
    public User getUser(int id) {

        Session session = null;
        Transaction transaction = null;
        User user;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            user = session.get(User.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);

        } finally {
            if (session != null) session.close();
        }
        return user;
    }

    @Override
    public boolean delete(int id) {
        Transaction transaction = null;
        User user;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            user = session.get(User.class, id);
            if (user == null) {
                return false;
            }
            session.delete(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw new RuntimeException(e);
        }
        return true;
    }
}



