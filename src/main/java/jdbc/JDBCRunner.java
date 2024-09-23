package jdbc;

import jdbc.dao.TicketDAOImpl;
import jdbc.dao.UserDAOImpl;
import jdbc.util.ConnectionManager;

import java.sql.SQLException;

public class JDBCRunner {
    public static void main(String[] args) throws SQLException {
        UserDAOImpl userDAO = UserDAOImpl.getInstance();
        System.out.println(userDAO.getUser(1));
        TicketDAOImpl ticketDAO = TicketDAOImpl.getInstance();
        System.out.println(ticketDAO.getTicket(1));
    }
}
