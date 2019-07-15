package app.controllers.FormControllers;


import app.Service.UserService.UserService;
import app.models.User.Roles;
import app.models.User.User;
import app.vallidation.UserValidatorErrors;
import app.vallidation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    private UserService service;
    private Validator userValidator;

    @Autowired
    public void setValidator(Validator userValidator) {
        this.userValidator = userValidator;
    }

    @Autowired
    public RegistrationController(UserService service) {
        this.service = service;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView confirmRegistration(@RequestParam("username")String username,
                                            @RequestParam("password")String password,
                                            @RequestParam("confirm_password")String confirmPassword){


        UserValidatorErrors error = userValidator.validate(username,password,confirmPassword);
        switch (error){
            case FieldAreEmpty:
                return new ModelAndView("pages/RegisterPage",
                        "informationMessage",
                        "Username and password can not be empty!");

            case UsernameIsAlreadyExist:
                return new ModelAndView("pages/RegisterPage",
                        "informationMessage",
                        "This username is already exists");

            case PasswordsDoNotMatch:
                return new ModelAndView("pages/RegisterPage",
                        "informationMessage",
                        "Password and ConfirmPassword do not match!");

        }

        service.save(new User(username,password, Roles.USER,2000));
        return new ModelAndView("pages/RegisterPage", "informationMessage",
                "User has been successfully added");

    }
}
