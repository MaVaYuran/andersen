package homework2;

public class TicketService {
    private static final String ID = "1";
    public static void main(String[] args) {

        for (int i = 0; i < 10 ; i++) {
            Ticket ticket = new Ticket("LaScala", i);
            System.out.println("ticket Number: " + (i+1) + " - " + ticket);

        }
    }
}
