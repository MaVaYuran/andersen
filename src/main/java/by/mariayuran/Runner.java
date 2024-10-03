package by.mariayuran;

import by.mariayuran.hibernate.dao.TicketDAOImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);

        TicketDAOImpl ticketDAO = context.getBean(TicketDAOImpl.class);
        System.out.println(ticketDAO.getTicket(3));
    }
}
