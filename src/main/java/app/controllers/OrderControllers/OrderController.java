package app.controllers.OrderControllers;


import app.Service.FlowerService.FlowerService;
import app.Service.OrderService.UserOrderService;
import app.models.Order.OrderItem;
import app.models.Order.UserOrder;

import app.models.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;



@Controller
public class OrderController {

    private FlowerService flowerService;
    private UserOrderService orderService;


    @Autowired
    public OrderController(FlowerService flowerService, UserOrderService orderService) {
        this.flowerService = flowerService;
        this.orderService = orderService;
    }

    @RequestMapping(value = "/userPage", method = RequestMethod.POST)
    public String saveOrderToSession(@RequestParam("FlowerId") int id,
                                     @RequestParam("Amount") int amount,
                                     RedirectAttributes redirectAttributes,
                                     HttpSession session) {

        List<OrderItem> orderItems = (ArrayList<OrderItem>) session.getAttribute("orderItemsList");
        orderItems.add(new OrderItem(flowerService.getFlower(id), amount));
        redirectAttributes.addFlashAttribute("orderItemsList", orderItems);
        return "redirect:/web/userPage";

    }

    @RequestMapping(value = "userPage/createOrder")
    public String createOrder(HttpSession session) {
        User currentUser = (User)session.getAttribute("currentUser");
        List<OrderItem> orderItems = (ArrayList<OrderItem>) session.getAttribute("orderItemsList");
        orderService.createOrder(currentUser,orderItems);
        orderItems.clear();
        return "redirect:/web/userPage";

    }

}