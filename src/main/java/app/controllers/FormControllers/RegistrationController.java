package app.controllers.FormControllers;


import app.Service.UserService.UserService;
import app.models.User.Roles;
import app.models.User.User;
import app.vallidation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    private UserService service;
    private UserValidator validator = new UserValidator();

    @Autowired
    public RegistrationController(UserService service) {
        this.service = service;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView confirmRegistration(@RequestParam("username")String username,
                                            @RequestParam("password")String password,
                                            @RequestParam("confirm_password")String confirmPassword){

       if(validator.isNull(username) || validator.isNull(password))
            return new ModelAndView("RegisterPage",
                            "informationMessage",
              "Username and password can not be empty!");


        if(validator.isUsernameAlreadyExist(username, service.getAll()))
            return new ModelAndView("RegisterPage",
                             "informationMessage",
               "This username is already exists");

        if(!validator.isPasswordsTheSame(password,confirmPassword))
            return new ModelAndView("RegisterPage",
                    "informationMessage",
              "Password and ConfirmPassword do not match!");


        service.save(new User(username,password, Roles.USER));
        return new ModelAndView("RegisterPage", "informationMessage",
                                           "User has been successfully added");
    }
}
