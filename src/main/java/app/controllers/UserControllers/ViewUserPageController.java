package app.controllers.UserControllers;


import app.Service.FlowerService.FlowerService;
import app.models.User.Roles;
import app.models.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class ViewUserPageController {

   private FlowerService flowerService;

    @Autowired
    public ViewUserPageController(FlowerService flowerService){
        this.flowerService = flowerService;
    }

    @RequestMapping(value = "/userPage", method = RequestMethod.GET)
    public ModelAndView sendUserPage(HttpSession session){
        User currentUser = (User)session.getAttribute("currentUser");
        if(currentUser!=null && currentUser.getRole().equals(Roles.USER)){
            ModelAndView modelAndView = new ModelAndView("pages/UserPage");
            modelAndView.addObject("flowerList",flowerService.getAllFlowers());
            return modelAndView;
        }
        return new ModelAndView("redirect:/web/signIn");
    }
}
