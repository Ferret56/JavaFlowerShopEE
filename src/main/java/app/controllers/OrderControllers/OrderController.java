package app.controllers.OrderControllers;


import app.Service.FlowerService.FlowerService;
import app.Service.OrderService.UserOrderService;
import app.Service.UserService.UserService;
import app.models.Order.OrderItem;
import app.models.Order.UserOrder;

import app.models.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import java.util.ArrayList;
import java.util.List;



@Controller
public class OrderController {

    private UserOrderService orderService;
    private UserService userService;

    @Autowired
    public OrderController(UserOrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @RequestMapping(value = "userPage/createOrder")
    public String createOrder(HttpSession session) {
        User currentUser = (User)session.getAttribute("currentUser");
        List<OrderItem> orderItems = (ArrayList<OrderItem>) session.getAttribute("orderItemsList");
        int currentCost = 0;
        for(OrderItem orderItem : orderItems){
            currentCost+= orderItem.getFlower().getPrice() * orderItem.getCount();
        }
        orderService.createOrder(currentUser,orderItems,currentCost);
        orderItems.clear();
        currentUser.setMoney(currentUser.getMoney() - currentCost);
        userService.updateUser(currentUser);
        return "redirect:/web/userPage";
    }

    @RequestMapping(value = "admin/remove/order/{id}")
    public String removeOrder(@PathVariable("id")int orderId, HttpServletRequest req){
        orderService.removeOrder(orderId);
        return  "redirect:/web/admin";
    }

}