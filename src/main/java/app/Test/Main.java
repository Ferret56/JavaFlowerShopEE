package app.Test;

import app.DAO.FlowerDao.FlowerDaoImpl;
import app.DAO.OrderDao.UserOrderDaoImpl;
import app.DAO.UserDao.UserDaoImpl;
import app.Service.FlowerService.FlowerServiceImpl;
import app.Service.OrderService.UserOrderService;
import app.Service.OrderService.UserOrderServiceImpl;
import app.Service.UserService.UserService;
import app.Service.UserService.UserServiceImpl;
import app.models.Flower.Flower;
import app.models.Order.OrderItem;
import app.models.Order.UserOrder;
import app.models.User.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl(new UserDaoImpl());
        FlowerServiceImpl flowerService = new FlowerServiceImpl(new FlowerDaoImpl());
        UserOrderService orderService = new UserOrderServiceImpl(new UserOrderDaoImpl());

        User user = userService.getUser(133);
        Flower flower = flowerService.getFlower(3);
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem(flower,12));
        Flower flower1 = flowerService.getFlower(4);
        orderItems.add(new OrderItem(flower1,45));

        orderService.createOrder(user,orderItems);

    }
}
