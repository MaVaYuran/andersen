package by.mariayuran.hibernate.dao;

import by.mariayuran.hibernate.entity.User;

public interface UserDAO {
    Integer save(User user);

    User getUser(int id);

    boolean delete(int id);

}
