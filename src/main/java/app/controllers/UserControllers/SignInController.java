package app.controllers.UserControllers;


import app.Service.UserService;
import app.models.User.User;
import app.vallidation.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignInController {

    private UserService service;
    private UserValidator validator = new UserValidator();

    public SignInController(UserService service) {
        this.service = service;
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public ModelAndView confirmSignIn(@RequestParam("username")String username,
                                      @RequestParam("password")String password){

        User user = validator.findByUsername(username,service.getAll());
        if(user == null || !(user.getPassword().equals(password)))
            return new ModelAndView("SignInPage","informationMessage",
                    "Wrong username or password!");

        return new ModelAndView("RegisterPage");
    }
}
