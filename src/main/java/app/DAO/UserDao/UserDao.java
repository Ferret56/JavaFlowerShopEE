package app.DAO.UserDao;

import app.models.User.User;

import java.util.List;


public interface UserDao {
    void addUser(User user);
    List<User> getAllUsers();
}
