package homework2;

public class TicketService {
    public static void main(String[] args) {
        Ticket ticket = new Ticket("Plaza", 290, false, Sector.A, 25.00f, 15.99);
        Ticket ticket1 = new Ticket("LaScala", 180);
        Ticket ticket2 = new Ticket();



        System.out.println("Full ticket:");
        System.out.println(ticket);
        System.out.println("Limited ticket:");
        System.out.println(ticket1);
        System.out.println("Empty ticket:") ;
        System.out.println(ticket2);
    }
}
