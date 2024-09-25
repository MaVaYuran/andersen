package hibernate.dao;

import hibernate.entity.User;

public interface UserDAO {
    Integer save(User user);

    User getUser(int id);

    boolean delete(int id);

}
