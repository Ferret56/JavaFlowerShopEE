package app.controllers.AdminControllers;


import app.models.User.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class ViewPageController {

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String sendAdminPage(){
              return "AdminPage";

    }
}
