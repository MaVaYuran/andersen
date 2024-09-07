package homework2;

import homework2.user.Admin;
import homework2.user.Client;
import homework2.user.User;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static homework2.Ticket.*;

public class TicketService {
    static List<Ticket> tickets = new ArrayList<>();

    public static void main(String[] args) {
        final String phoneNumber = "37577777777";
        final String email = "useremail@gmail.com";

        generateTickets(10);
        Random random = new Random();
        int ticketId = random.nextInt(10) + 1;

        sharedByPhone(ticketId, phoneNumber);
        sharedByPhoneAndEmail(ticketId, phoneNumber, email);

        User client = new Client(1);
        User admin = new Admin(1);
        client.printRole();
        admin.printRole();

        Ticket actualTicket = ((Client)client).getTicket();
        System.out.println("Client's ticket: " + actualTicket);
        System.out.println("Is the ticket actual? " + ((Admin)admin).checkTicket(actualTicket));;

    }

    public static void generateTickets(int numberOfTickets) {
        Sector sector;
        int count = 1;

        for (int i = 1; i <= numberOfTickets; i++) {
            if (i % 2 == 0) {
                sector = Sector.A;
            } else if (i % 5 == 0) {
                sector = Sector.B;
            } else {
                sector = Sector.C;
            }

            int id = count;
            Ticket ticket = new Ticket(id, "LaScala", (i + 100), true, sector, 10.0f, 9.99);
            count++;
            tickets.add(ticket);
        }
    }

    public static Ticket getTicketById(int id) {
        for (Ticket ticket : tickets) {
            if (id == ticket.getId()) {
                return ticket;
            }
        }
        return null;

    }

    public static List<Ticket> getTicketBySector(Sector sector) {
        List<Ticket> ticketsBySector = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (sector.equals(ticket.getSector())) {
                ticketsBySector.add(ticket);
            }
        }
        return ticketsBySector;
    }
}
