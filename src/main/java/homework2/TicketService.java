package homework2;

import java.util.ArrayList;
import java.util.List;

public class TicketService {
    static List<Ticket> tickets = new ArrayList<>();

    public static void main(String[] args) {

        int count = 1;

        for (int i = 0; i < 10; i++) {
            String id = Integer.toString(count);
            Ticket ticket = new Ticket(id, "LaScala", (i+100), true, Sector.B, 10.0f, 9.99);
            count++;
            tickets.add(ticket);
        }

        System.out.println(tickets);

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


}
