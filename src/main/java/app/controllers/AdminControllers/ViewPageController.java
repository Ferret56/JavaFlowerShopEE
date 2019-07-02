package app.controllers.AdminControllers;


import app.models.User.Roles;
import app.models.User.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class ViewPageController {

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String sendAdminPage(HttpSession session){
        User currentUser = (User)session.getAttribute("currentUser");
        if( currentUser!=null && currentUser.getRole().equals(Roles.ADMIN))
                   return "AdminPage";

        return "redirect:/web/signIn";
    }
}
