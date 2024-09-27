package hibernate;

import hibernate.dao.TicketDAOImpl;
import hibernate.dao.UserDAOImpl;
import hibernate.entity.Ticket;
import hibernate.entity.User;
import hibernate.util.HibernateUtil;
import homework.TicketType;

import java.time.LocalDate;


public class HibernateRunner {
    public static void main(String[] args) {

        UserDAOImpl userDAO = new UserDAOImpl(HibernateUtil.buildSessionFactory());
        System.out.println(userDAO.save(new User("Rafael", LocalDate.now())));
        System.out.println(userDAO.getUser(1));
        System.out.println(userDAO.delete(10));

        TicketDAOImpl ticketDAO = new TicketDAOImpl(HibernateUtil.buildSessionFactory());
        User user = userDAO.getUser(3);
        System.out.println(ticketDAO.save(new Ticket(user,TicketType.DAY, LocalDate.now())));
        System.out.println(ticketDAO.getTicket(7));
        System.out.println(ticketDAO.getUserTickets(4));

    }
}
