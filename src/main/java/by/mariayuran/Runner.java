package by.mariayuran;

import by.mariayuran.springboot.dao.UserDAO;
import by.mariayuran.springboot.entity.Ticket;
import by.mariayuran.springboot.entity.User;
import by.mariayuran.springboot.service.JSONTicketLoader;
import by.mariayuran.homework.TicketType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class Runner {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(Runner.class);
    }

}
