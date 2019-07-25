package app.vallidation;


import app.Service.UserService.UserService;
import app.models.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserSignInValidator implements Validator {

    private UserService userService;

    @Autowired
    public UserSignInValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        User currentUser = (User)obj;
        User testUser = userService.getUserByName(currentUser.getUsername());
        if(testUser==null || !currentUser.getPassword()
                             .equals(testUser.getPassword()))

          errors.reject("username", "Wrong username or password!");
    }
}
