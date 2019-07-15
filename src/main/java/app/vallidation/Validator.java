package app.vallidation;


import app.Service.UserService.UserService;
import app.models.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class Validator {
    private UserService userService;

    @Autowired
    public Validator(UserService userService) {
        this.userService = userService;
    }

    public UserValidatorErrors validate(final String username,
                                         final String password,
                                         final String confirmPassword){

        if(isFieldNull(username) || isFieldNull(password))
            return UserValidatorErrors.FieldAreEmpty;

        if(isUsernameAlreadyExist(username))
            return UserValidatorErrors.UsernameIsAlreadyExist;

        if(!isPasswordsTheSame(password,confirmPassword))
            return UserValidatorErrors.PasswordsDoNotMatch;

        return UserValidatorErrors.OK;
    }

    public Validator() {
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public boolean isUserAlreadyExist(final String username,
                                      final String password){
        List<User> userList = userService.getAll();
        for(User user : userList){
            if(username.equals(user.getUsername()) && password.equals(user.getPassword()))
                return  true;
        }
        return false;
    }
    public boolean isUsernameAlreadyExist(final String username){
        List<User> userList = userService.getAll();
        for(User user : userList){
            if(username.equals(user.getUsername()))
                return true;
        }
        return  false;
    }

    public boolean isFieldNull(final String field){
        return  field.equals("");
    }

    public boolean isPasswordsTheSame(final String password,
                                      final String confirmPassword){
        return password.equals(confirmPassword);
    }
}
