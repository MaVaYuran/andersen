package by.mariayuran.springboot.dao;

import by.mariayuran.springboot.entity.Ticket;
import by.mariayuran.springboot.entity.User;

public interface UserDAO {
    void save(User user);

    User getUser(int id);

    boolean delete(int id);

    void activateUserAndUpdateTicket(Integer id, Ticket ticket);
}
