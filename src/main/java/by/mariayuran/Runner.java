package by.mariayuran;

import by.mariayuran.hibernate.dao.TicketDAO;
import by.mariayuran.hibernate.dao.UserDAO;
import by.mariayuran.hibernate.entity.Ticket;
import by.mariayuran.hibernate.entity.User;
import by.mariayuran.homework.TicketType;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        TicketDAO ticketDAO = context.getBean(TicketDAO.class);
        UserDAO userDAO = context.getBean(UserDAO.class);
        User user = new User("Ivan", LocalDate.now());
        userDAO.save(user);
        Ticket ticket = new Ticket(user, TicketType.YEAR, LocalDate.now());
        userDAO.activateUserAndUpdateTicket(user.getId(), ticket);
    }
}
