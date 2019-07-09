package app.Service.OrderService;

import app.DAO.OrderDao.UserOrderDao;
import app.models.Order.OrderItem;
import app.models.Order.UserOrder;
import app.models.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderServiceImpl implements UserOrderService {

    private UserOrderDao dao;

    @Autowired
    public UserOrderServiceImpl(UserOrderDao dao) {
        this.dao = dao;
    }

    @Override
    public void createOrder(User user, List<OrderItem> orderItemList) {
            dao.createOrder(user,orderItemList);
    }

    @Override
    public void removeOrder(int id) {
        dao.removeOrder(id);
    }

    @Override
    public List<UserOrder> getAllOrders(int PersonId) {
        return dao.getAllOrders(PersonId);
    }
}
