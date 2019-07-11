package app.Service.UserService;

import app.DAO.UserDao.UserDao;
import app.models.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {


    private UserDao dao;

    @Autowired
    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void save(User user) {
    // dao = new UserDaoImpl();
     dao.addUser(user);
    }

    @Override
    public List<User> getAll() {
        return dao.getAllUsers();
    }

    @Override
    public User getUser(int id) {
        return dao.getUser(id);
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }
}
