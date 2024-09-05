package homework2.user;

public class Admin extends User {
    @Override
    public void printRole() {
        System.out.println("Role admin");
    }
    public void checkTicket() {
        System.out.println("Check ticket method for Admin");
    }
}
