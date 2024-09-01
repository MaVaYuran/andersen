package homework2;

public class TicketService {
    private static final int ID = 1;
    public static void main(String[] args) {

        Ticket fullTicket = new Ticket(ID,"Plaza", 290, false, Sector.A, 25.00f, 15.99);
        Ticket limitedTicket = new Ticket("LaScala", 180);
        Ticket emptyTicket = new Ticket();



        System.out.println("Full ticket:");
        System.out.println(fullTicket);
        System.out.println("Limited ticket:");
        System.out.println(limitedTicket);
        System.out.println("Empty ticket:") ;
        System.out.println(emptyTicket);
    }
}
