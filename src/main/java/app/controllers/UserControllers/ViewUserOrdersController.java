package app.controllers.UserControllers;


import app.Service.OrderService.UserOrderService;
import app.models.Order.UserOrder;
import app.models.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ViewUserOrdersController {

    private UserOrderService userOrderService;

    @Autowired
    public ViewUserOrdersController(UserOrderService userOrderService) {
        this.userOrderService = userOrderService;
    }

    @RequestMapping(value = "/viewOrders")
    public ModelAndView viewOrdersPage(HttpSession session){
        User currentUser = (User)session.getAttribute("currentUser");
        List<UserOrder> ordersList = userOrderService.getAllOrders(currentUser.getId());
        ModelAndView modelAndView = new ModelAndView("pages/UserOrdersPage");
        modelAndView.addObject("ordersList", ordersList);
        return modelAndView;
    }

}
