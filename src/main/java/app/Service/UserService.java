package app.Service;

import app.models.User.User;

import java.util.List;

public interface UserService {

    void save(User user);
    List<User> getAll();
}
