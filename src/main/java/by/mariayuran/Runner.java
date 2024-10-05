package by.mariayuran;

import by.mariayuran.hibernate.dao.TicketDAOImpl;
import by.mariayuran.hibernate.dao.UserDAOImpl;
import by.mariayuran.hibernate.entity.Ticket;
import by.mariayuran.hibernate.entity.User;
import by.mariayuran.homework.TicketType;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        User newUser = new User("Ivan", LocalDate.now());
//        Ticket ticket = new Ticket(newUser , TicketType.DAY, LocalDate.now());
        TicketDAOImpl ticketDAO = context.getBean(TicketDAOImpl.class);
        UserDAOImpl userDAO = context.getBean(UserDAOImpl.class);
//        userDAO.activateUserAndUpdateTicket(newUser.getId(), ticket);

    }
}
