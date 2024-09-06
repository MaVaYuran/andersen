package homework2.user;

import static homework2.TicketService.getTicketById;

public class Admin extends User {
    private int id;
    @Override
    public int getId() {
        return id;
    }
    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void printRole() {
        System.out.println("Role admin");
    }
    public void checkTicket(int ticketId) {
        getTicketById(ticketId);
    }
}
