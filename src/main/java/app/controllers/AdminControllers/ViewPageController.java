package app.controllers.AdminControllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewPageController {

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String sendAdminPage(){
        return "AdminPage";
    }
}
