package app.DAO;

import app.models.User.User;
import org.springframework.stereotype.Repository;



public interface UserDao {
    void addUser(User user);
}
