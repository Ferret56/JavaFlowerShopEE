package app.controllers.FormControllers;


import app.Service.UserService.UserService;
import app.models.User.Roles;
import app.models.User.User;
import app.vallidation.UserRegisterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    private UserService service;
    private UserRegisterValidator userRegisterValidator;


    @Autowired
    public void setUserRegisterValidator(UserRegisterValidator userRegisterValidator) {
        this.userRegisterValidator = userRegisterValidator;
    }

    @Autowired
    public RegistrationController(UserService service) {
        this.service = service;
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView confirmRegistration(User formUser,
                                            BindingResult result) {

        userRegisterValidator.validate(formUser, result);
        if (result.hasErrors())
            return new ModelAndView("pages/RegisterPage");

        service.save(new User(formUser.getUsername(), formUser.getPassword(),
                formUser.getConfirm_password(), Roles.USER, 2000));

        return new ModelAndView("pages/RegisterPage", "successMessage",
                "User has been successfully added");
    }
}
