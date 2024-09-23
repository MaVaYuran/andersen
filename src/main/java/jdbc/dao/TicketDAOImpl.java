package jdbc.dao;

import homework.TicketType;
import jdbc.pojo.Ticket;
import jdbc.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDAOImpl implements TicketDAO {
    private final static TicketDAOImpl INSTANCE = new TicketDAOImpl();
    private final static String SAVE_SQL = """
            INSERT INTO ticket
             (user_id, ticket_type)
             VALUES(?,?)
            """;
    private final static String GET_BY_ID_SQL = """
            SELECT * FROM ticket
            WHERE id=?
            """;
    private final static String GET_BY_USER_ID_SQL = """
            SELECT * FROM ticket
            WHERE user_id=?
            """;
    private static final String UPDATE_TYPE_SQL = """
            UPDATE ticket SET ticket_type=?
            WHERE id=?
            """;


    public Ticket save(Ticket t) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement statement = connection.prepareStatement(SAVE_SQL)) {
            statement.setInt(1, t.getUserId());
            statement.setString(2, t.getTicketType().toString());

            statement.executeUpdate();
            return t;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Ticket getTicket(int id) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement statement = connection.prepareStatement(GET_BY_ID_SQL)) {
            statement.setInt(1, id);
            try (ResultSet result = statement.executeQuery()) {
                Ticket ticket;
                if (result.next()) {
                    ticket = buildTicket(result);
                    return ticket;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return null;
    }

       @Override
    public List<Ticket> getUserTickets(int userId) {
        List<Ticket> userTickets = new ArrayList<>();
        try (Connection connection = ConnectionManager.open();
             PreparedStatement statement = connection.prepareStatement(GET_BY_USER_ID_SQL)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    userTickets.add(buildTicket(resultSet));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userTickets;
    }

    @Override
    public void updateTicketType(int id, TicketType newTicketType) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement statement = connection.prepareStatement(UPDATE_TYPE_SQL)) {
            statement.setString(1, newTicketType.name());
            statement.setInt(2, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private Ticket buildTicket(ResultSet result) throws SQLException {
        return new Ticket(result.getInt("id"),
                result.getInt("user_id"),
                TicketType.valueOf(result.getString("ticket_type")),
                result.getTimestamp("creation_date"));

    }

    public static TicketDAOImpl getInstance() {
        return INSTANCE;
    }

    private TicketDAOImpl() {
    }
}
