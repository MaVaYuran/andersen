package jdbc.dao;

import jdbc.pojo.Users;
import jdbc.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    private final static UserDAOImpl INSTANCE = new UserDAOImpl();

    private final static String SAVE_SQL = """
            INSERT INTO users (name) VALUES(?)
            """;

    private final static String GET_SQL = """
            SELECT * FROM users WHERE id=?
            """;
    private static final String DELETE_SQL = """
            DELETE FROM users WHERE id=?
            """;

    @Override
    public Users save(Users user) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement statement = connection.prepareStatement(SAVE_SQL)) {
            statement.setString(1, user.getName());

            statement.executeUpdate();
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Users getUser(int id) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement statement = connection.prepareStatement(GET_SQL)) {
            statement.setInt(1, id);
            try ( ResultSet result = statement.executeQuery()) {

                Users user;
                if (result.next()) {
                    user = new Users(result.getInt("id"),
                            result.getString("name"),
                            result.getTimestamp("creation_date")
                    );
                    return user;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static UserDAOImpl getInstance() {
        return INSTANCE;
    }

    private UserDAOImpl() {
    }

}
