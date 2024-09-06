package homework2.user;

import static homework2.TicketService.getTicketById;

public class Admin extends User {


    @Override
    public void printRole() {
        System.out.println("Role admin");
    }
    public void checkTicket(int ticketId) {
        getTicketById(ticketId);
    }
}
