package by.mariayuran.homework.user;

import by.mariayuran.homework.ConcertTicket;

public class Admin extends User {

    public Admin(int id) {
        super( id);
    }
    public boolean checkTicket(ConcertTicket ticket) {
        return ticket != null;
    }

    @Override
    public void printRole() {
        System.out.println("Role is: " + Role.ADMIN);
    }

}
