package jdbc.dao;

import jdbc.pojo.User;

public interface UserDAO {
    User save(User user);
    User getUser(int id);
    boolean delete(int id);
}
