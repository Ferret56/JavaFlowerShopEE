package app.controllers.OrderControllers;
import app.Service.FlowerService.FlowerService;
import app.models.Flower.Flower;
import app.models.Order.OrderItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SessionOrderController {

    private FlowerService flowerService;

    @Autowired
    public SessionOrderController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @RequestMapping(value = "/userPage", method = RequestMethod.POST)
    public String saveOrderToSession(@RequestParam("FlowerId") int id,
                                     @RequestParam("Amount") int amount,
                                     RedirectAttributes redirectAttributes,
                                     HttpSession session){

        List<OrderItem> orderItems = (ArrayList<OrderItem>) session.getAttribute("orderItemsList");
        Flower currentFlower = flowerService.getFlower(id);
        orderItems.add(new OrderItem(currentFlower, amount));
        int currentCost = 0;
        for(OrderItem orderItem : orderItems){
            currentCost+= orderItem.getFlower().getPrice() * orderItem.getCount();

        }
        redirectAttributes.addFlashAttribute("orderItemsList", orderItems);
        redirectAttributes.addFlashAttribute("currentCost", currentCost);
        return "redirect:/web/userPage";
    }

    @RequestMapping(value = "userPage/clearOrder")
    public String clearOrderFromSession(HttpSession session){
        List<OrderItem> orderItems = (ArrayList<OrderItem>) session.getAttribute("orderItemsList");
        orderItems.clear();
        return "redirect:/web/userPage";
    }
}
