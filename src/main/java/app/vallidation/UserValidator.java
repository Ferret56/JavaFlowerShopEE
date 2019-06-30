package app.vallidation;

import app.models.User.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class UserValidator {
   public  boolean isNull(final String str){
        return str.equals("");
    }

   public boolean isUsernameAlreadyExist(final String username, List<User> usersList){
        for(User user : usersList){
            if(username.equals(user.getUsername())){
                return true;
            }
        }
        return false;
    }

    public boolean isPasswordsTheSame(final String password, final String confirmPassword){
       return password.equals(confirmPassword);
    }

    public User findByUsername(final String username, List<User> userList){
       for(User user : userList){
           if(username.equals(user.getUsername()))
               return user;
       }
       return null;
    }

}
