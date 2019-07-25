package app.vallidation;


import app.Service.UserService.UserService;
import app.models.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserRegisterValidator implements Validator {

    private UserService userService;

    @Autowired
    public UserRegisterValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return  User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        User formUser = (User)obj;
        if(formUser.getUsername().equals("") ||
                formUser.getPassword().equals("")){
            errors.reject("password", "Username or password can not be empty!");
        }

        if(userService.getUserByName(formUser.getUsername())!= null)
            errors.reject("username","This username is already exists");

        if(!formUser.getPassword().equals(formUser.getConfirm_password()))
            errors.reject("password","Password and ConfirmPassword do not match!");
    }
}
