package app.controllers;


import app.Service.UserService;
import app.Service.UserServiceImpl;
import app.models.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public String test(){
        return "SignInPage";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(){
        User user = new User("test","test");
        service.save(user);

        return "RegisterPage";
    }
}
