package app.controllers.OrderControllers;

import app.Service.FlowerService.FlowerService;
import app.Service.OrderService.UserOrderService;
import app.Service.UserService.UserService;
import app.models.Flower.Flower;
import app.models.Order.OrderItem;
import app.models.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    private UserOrderService orderService;
    private UserService userService;
    private FlowerService flowerService;

    @Autowired
    public OrderController(UserOrderService orderService, UserService userService, FlowerService flowerService) {
        this.orderService = orderService;
        this.userService = userService;
        this.flowerService = flowerService;
    }

    @RequestMapping(value = "userPage/createOrder")
    public String createOrder(HttpSession session, RedirectAttributes redirectAttributes) {
        User currentUser = (User)session.getAttribute("currentUser");
        List<OrderItem> orderItems = (ArrayList<OrderItem>) session.getAttribute("orderItemsList");
        int currentCost = 0;
        for(OrderItem orderItem : orderItems){
            if(orderItem.getCount() > orderItem.getFlower().getAmount()) {
                redirectAttributes.addFlashAttribute("informationMessage",
                        "Order creation error!" + "[" + orderItem.getFlower().getName() + "]");
                return "redirect:/web/userPage";
            }
            currentCost+= orderItem.getFlower().getPrice() * orderItem.getCount();
        }
        if(currentCost > currentUser.getMoney()){
            redirectAttributes.addFlashAttribute("informationMessage",
                    "Order creation error! You don't have enough money");
            redirectAttributes.addFlashAttribute("currentCost", currentCost);
            return "redirect:/web/userPage";
        }
        orderService.createOrder(currentUser,orderItems,currentCost);
        currentUser.setMoney(currentUser.getMoney() - currentCost);
        userService.updateUser(currentUser);
        for(OrderItem orderItem : orderItems){
            Flower currentFlower = orderItem.getFlower();
            currentFlower.setAmount(currentFlower.getAmount() - orderItem.getCount());
            flowerService.updateFlower(currentFlower);
        }
        orderItems.clear();
        return "redirect:/web/userPage";
    }

    @RequestMapping(value = "admin/remove/order/{id}")
    public String removeOrder(@PathVariable("id")int orderId){
        orderService.removeOrder(orderId);
        return  "redirect:/web/admin";
    }

}