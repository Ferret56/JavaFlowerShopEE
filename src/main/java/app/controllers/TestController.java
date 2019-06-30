package app.controllers;


import app.Service.UserServiceImpl;
import app.models.User.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String test(){
        return "SignInPage";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(){
        User user = new User("test","test");
        UserServiceImpl service = new UserServiceImpl();
        service.save(user);

        return "RegisterPage";
    }
}
