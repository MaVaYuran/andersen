package by.mariayuran.hibernate;

import by.mariayuran.hibernate.dao.TicketDAOImpl;
import by.mariayuran.hibernate.dao.UserDAOImpl;
import by.mariayuran.hibernate.entity.Ticket;
import by.mariayuran.hibernate.entity.User;
import by.mariayuran.homework.TicketType;

import java.time.LocalDate;


public class HibernateRunner {
    public static void main(String[] args) {

//        UserDAOImpl userDAO = new UserDAOImpl(HibernateUtil.buildSessionFactory());
//        System.out.println(userDAO.save(new User("Rafael", LocalDate.now())));
//        System.out.println(userDAO.getUser(1));
//        System.out.println(userDAO.delete(10));
//
//        TicketDAOImpl ticketDAO = new TicketDAOImpl(HibernateUtil.buildSessionFactory());
//        User user = userDAO.getUser(3);
//        System.out.println(ticketDAO.save(new Ticket(user,TicketType.DAY, LocalDate.now())));
//        System.out.println(ticketDAO.getTicket(7));
//        System.out.println(ticketDAO.getUserTickets(4));

    }
}
