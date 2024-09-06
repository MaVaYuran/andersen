package homework2.user;

import homework2.Ticket;

public class Client extends User {
    private int id;
    private Ticket ticket;



    @Override
    public void printRole() {
        System.out.println("Role Client");
    }

    public Ticket getTicket() {
        return ticket;
    }
}
