package hibernate;

import hibernate.dao.TicketDAOImpl;
import hibernate.dao.UserDAOImpl;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import java.sql.SQLException;

public class HibernateRunner {
    public static void main(String[] args) throws SQLException {

        try(SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
            Session session = sessionFactory.openSession()){
            System.out.println("ok");
        }
//        UserDAOImpl userDAO = UserDAOImpl.getInstance();
//        System.out.println(userDAO.getUser(2));
//        TicketDAOImpl ticketDAO = TicketDAOImpl.getInstance();
//        System.out.println(ticketDAO.getTicket(2));
    }
}
