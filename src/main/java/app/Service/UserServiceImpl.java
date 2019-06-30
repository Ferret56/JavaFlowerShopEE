package app.Service;

import app.DAO.UserDao;
import app.DAO.UserDaoImpl;
import app.models.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
}
