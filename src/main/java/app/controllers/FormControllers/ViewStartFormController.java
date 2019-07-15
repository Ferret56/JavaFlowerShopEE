package app.controllers.FormControllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewStartFormController {
    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String test(){
        return "pages/SignInPage";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(){
        return "pages/RegisterPage";
    }
}
