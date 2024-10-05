package by.mariayuran.hibernate.dao;

import by.mariayuran.hibernate.entity.User;

public interface UserDAO {
    void save(User user);

    User getUser(int id);

    boolean delete(int id);

}
