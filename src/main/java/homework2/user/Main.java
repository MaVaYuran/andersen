package homework2.user;

public class Main {
    public static void main(String[] args) {
  final int id = 5;
        Client client  = new Client();
        Admin admin = new Admin();

        client.printRole();
        admin.printRole();

        client.getTicket();
        admin.checkTicket(id);
    }
}
