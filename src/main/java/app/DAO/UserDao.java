package app.DAO;

import app.models.User.User;

import java.util.List;


public interface UserDao {
    void addUser(User user);
    List<User> getAllUsers();
}