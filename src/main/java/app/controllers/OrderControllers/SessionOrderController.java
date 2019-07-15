package app.controllers.OrderControllers;
import app.Service.FlowerService.FlowerService;
import app.models.Basket.Basket;
import app.models.Flower.Flower;
import app.models.Order.OrderItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;


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
                                     HttpSession session){

        Basket currentBasket = (Basket)session.getAttribute("currentBasket");
        Flower currentFlower = flowerService.getFlower(id);
        currentBasket.addOrderItem(new OrderItem(currentFlower,amount));
        return "redirect:/web/userPage";
    }

    @RequestMapping(value = "userPage/clearOrder")
    public String clearOrderFromSession(HttpSession session){
        ((Basket)session.getAttribute("currentBasket")).clear();
        return "redirect:/web/userPage";
    }
}
