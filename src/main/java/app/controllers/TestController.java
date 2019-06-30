package app.controllers;


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
        return "RegisterPage";
    }
}