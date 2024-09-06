package homework2;

import java.util.ArrayList;
import java.util.List;

public class TicketService {
    static List<Ticket> tickets = new ArrayList<>();

    public static void main(String[] args) {
        Sector sector;
        int count = 1;

        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                sector = Sector.A;
            } else if (i % 5 == 0) {
                sector = Sector.B;
            } else {
                sector = Sector.C;
            }

            String id = Integer.toString(count);
            Ticket ticket = new Ticket(id, "LaScala", (i + 100), true, sector, 10.0f, 9.99);
            count++;
            tickets.add(ticket);

        }

        System.out.println(tickets);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Ticket from method: " + getTicketBySector(Sector.A));
        System.out.println("Ticket from method: " + getTicketById("8"));
    }

    static Ticket getTicketById(String id) {
        for (Ticket ticket : tickets) {
            if (id.equals(ticket.getId())) {
                return ticket;
            }
        }
        return null;

    }

    static List<Ticket> getTicketBySector(Sector sector) {
        List<Ticket> ticketsBySector = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (sector.equals(ticket.getSector())) {
                ticketsBySector.add(ticket);
            }
        }
        return ticketsBySector;
    }
}
