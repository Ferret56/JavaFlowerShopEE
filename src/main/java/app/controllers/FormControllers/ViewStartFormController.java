package app.controllers.FormControllers;


import app.models.User.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewStartFormController {
    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String test(Model model){
        model.addAttribute("user", new User());
        return "pages/SignInPage";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(){
        return "pages/RegisterPage";
    }
}
