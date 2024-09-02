package homework2;

public class TicketService {
      public static void main(String[] args) {

        for (int i = 0; i < 10 ; i++) {
            Ticket ticket = new Ticket("LaScala", i);
            System.out.println("ticket Number: " + (i+1) + " - " + ticket);

        }
    }
}
