package hibernate;

import hibernate.dao.TicketDAOImpl;
import hibernate.dao.UserDAOImpl;
import hibernate.entity.Ticket;
import hibernate.entity.User;
import hibernate.util.HibernateUtil;
import homework.TicketType;

public class HibernateRunner {
    public static void main(String[] args) {

        UserDAOImpl userDAO = new UserDAOImpl(HibernateUtil.buildSessionFactory());
        System.out.println(userDAO.save(new User("Oleg")));

        TicketDAOImpl ticketDAO = new TicketDAOImpl(HibernateUtil.buildSessionFactory());
        System.out.println(ticketDAO.save(new Ticket(4, TicketType.MONTH)));

    }
}
