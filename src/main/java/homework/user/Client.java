package homework.user;

import homework.Ticket;

public class Client extends User {
    private Ticket ticket;

    public Client(int id) {
        super(id);

    }

    public Ticket getTicket() {
        return new Ticket();
    }



    @Override
    public void printRole() {
        System.out.println("Role is: " + Role.CLIENT);
    }


}
