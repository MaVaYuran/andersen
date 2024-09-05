package homework2.user;

public class Client extends User {
    @Override
    public void printRole() {
        System.out.println("Role Client");
    }
    public void getTicket() {
        System.out.println("Get ticket method for Client");
    }
}
