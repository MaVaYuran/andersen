package homework.user;

import homework.ConcertTicket;


public class Client extends User {
    private ConcertTicket ticket;

    public Client(int id) {
        super(id);

    }

    public ConcertTicket getTicket() {
        return new ConcertTicket();
    }



    @Override
    public void printRole() {
        System.out.println("Role is: " + Role.CLIENT);
    }


}
