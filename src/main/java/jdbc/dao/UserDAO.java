package jdbc.dao;

import jdbc.pojo.Ticket;
import jdbc.pojo.Users;

public interface UserDAO {
    Users save(Users user);
    Users getUser(int id);
    boolean delete(int id);
}
