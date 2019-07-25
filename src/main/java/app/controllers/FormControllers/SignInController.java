package app.controllers.FormControllers;
import app.Service.UserService.UserService;
import app.models.Basket.Basket;
import app.models.User.Roles;
import app.models.User.User;
import app.vallidation.UserSignInValidator;
import app.vallidation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;



@Controller
public class SignInController {

    private UserService userService;
    private Basket basket;
    private UserSignInValidator userSignInValidator;



    @Autowired
    public SignInController(UserService service) {
        this.userService = service;
    }

    @Autowired
    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    @Autowired
    public void setUserSignInValidator(UserSignInValidator userSignInValidator) {
        this.userSignInValidator = userSignInValidator;
    }

    public Basket getBasket() {
        return basket;
    }



    /*@RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String confirmSignIn(@RequestParam("username")String username,
                                @RequestParam("password")String password,
                                RedirectAttributes redirectAttributes,
                                HttpSession session){

        User currentUser = userService.getUserByName(username);

        if(!userValidator.isUserAlreadyExist(username,password)){
           redirectAttributes.addFlashAttribute("informationMessage",
                                                 "Wrong username or password!!");
           return "redirect:/web/signIn";
        }

        session.setAttribute("currentUser",currentUser );
        session.setAttribute("currentBasket", new Basket());
        if(currentUser.getRole().equals(Roles.ADMIN))
                       return "redirect:/web/admin";

        return "redirect:/web/userPage";
    }
    */
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String confirmSignIn(User formUser,
                                BindingResult result,
                                HttpSession session){

        userSignInValidator.validate(formUser,result);
        if(result.hasErrors())
            return "pages/SignInPage";

        User currentUser = userService.getUserByName(formUser.getUsername());

        session.setAttribute("currentUser",currentUser );
        session.setAttribute("currentBasket", new Basket());
        if(currentUser.getRole().equals(Roles.ADMIN))
            return "redirect:/web/admin";

        return "redirect:/web/userPage";
    }

}
