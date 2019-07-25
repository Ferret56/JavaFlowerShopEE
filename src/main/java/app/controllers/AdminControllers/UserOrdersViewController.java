package app.controllers.AdminControllers;


import app.Service.OrderService.UserOrderService;
import app.models.Order.UserOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserOrdersViewController {

    private UserOrderService userOrderService;

    @Autowired
    public UserOrdersViewController(UserOrderService userOrderService) {
        this.userOrderService = userOrderService;
    }

    @RequestMapping(value = "/admin/user/{id}")
    public ModelAndView viewUserOrdersPage(@PathVariable("id")int userId){
        List<UserOrder> ordersList =  userOrderService.getAllOrders(userId);
        ModelAndView modelAndView = new ModelAndView("pages/UserOrdersPage");
        modelAndView.addObject("ordersList",ordersList);
       // modelAndView.addObject("userId",userId);
        return modelAndView;
    }

}
