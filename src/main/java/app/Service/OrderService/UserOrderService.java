package app.Service.OrderService;

import app.models.Order.OrderItem;
import app.models.User.User;

import java.util.List;

public interface UserOrderService {
    void createOrder(User user, List<OrderItem> orderItemList);
    void removeOrder(int id);
}
