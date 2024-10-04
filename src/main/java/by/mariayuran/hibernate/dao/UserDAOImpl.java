package by.mariayuran.hibernate.dao;

import by.mariayuran.hibernate.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
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

        try (Session session = sessionFactory.openSession()) {
            Integer savedId;
            Transaction transaction = session.beginTransaction();
            savedId = (Integer) session.save(user);
            transaction.commit();
            return savedId;
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User getUser(int id) {

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            return session.get(User.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean delete(int id) {

        try (Session session = sessionFactory.openSession()) {
            User user;
            Transaction transaction = session.beginTransaction();
            user = session.get(User.class, id);
            if (user == null) {
                return false;
            }
            session.delete(user);
            transaction.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return true;
    }
}



