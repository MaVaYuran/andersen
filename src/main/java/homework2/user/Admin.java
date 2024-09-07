package homework2.user;

import homework2.Ticket;


public class Admin extends User {

    public Admin(int id) {
        super( id);
    }
    public boolean checkTicket(Ticket ticket) {
        return ticket != null;
    }

    @Override
    public void printRole() {
        System.out.println("Role is: " + Role.ADMIN);
    }

}
