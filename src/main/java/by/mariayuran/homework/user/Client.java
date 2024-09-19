package by.mariayuran.homework.user;

import by.mariayuran.homework.Ticket;

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
