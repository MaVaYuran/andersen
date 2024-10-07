package by.mariayuran;

import by.mariayuran.hibernate.dao.TicketDAO;
import by.mariayuran.hibernate.dao.UserDAO;
import by.mariayuran.hibernate.entity.Ticket;
import by.mariayuran.hibernate.entity.User;
import by.mariayuran.hibernate.service.JSONTicketLoader;
import by.mariayuran.homework.TicketType;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;


public class Runner {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserDAO userDAO = context.getBean(UserDAO.class);
        User user = new User("Ivan");
        userDAO.save(user);
        Ticket ticket = new Ticket(user, TicketType.YEAR);
        userDAO.activateUserAndUpdateTicket(user.getId(), ticket);
        JSONTicketLoader ticketLoader = context.getBean(JSONTicketLoader.class);
        System.out.println(ticketLoader.loadTicketsFromJSON());
    }
}
