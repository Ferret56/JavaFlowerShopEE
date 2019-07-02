package app.controllers.UserControllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewUserPageController {

    @RequestMapping(value = "/userPage", method = RequestMethod.GET)
    public String sendUserPage(){
        return "UserPage";
    }
}
