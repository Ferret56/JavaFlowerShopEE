package app.controllers.UserControllers;


import app.models.User.Roles;
import app.models.User.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class ViewUserPageController {

    @RequestMapping(value = "/userPage", method = RequestMethod.GET)
    public String sendUserPage(HttpSession session){
        User currentUser = (User)session.getAttribute("currentUser");
        if(currentUser!=null && currentUser.getRole().equals(Roles.USER))
             return "UserPage";

        return "redirect:/web/signIn";
    }
}
