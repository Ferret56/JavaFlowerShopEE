package app.DAO.OrderDao;

import app.models.Order.OrderItem;
import app.models.User.User;

import java.util.List;

public interface UserOrderDao {

    void createOrder(User user, List<OrderItem> orderItemList);
    void removeOrder(int id);
}
