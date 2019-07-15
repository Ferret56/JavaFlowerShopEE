package app.controllers.FormControllers;
import app.Service.UserService.UserService;
import app.models.Basket.Basket;
import app.models.User.Roles;
import app.models.User.User;
import app.vallidation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;



@Controller
public class SignInController {

    private UserService userService;
    private Validator userValidator;
    private Basket basket;


    @Autowired
    public void setValidator(Validator userValidator) {
        this.userValidator = userValidator;
    }

    @Autowired
    public SignInController(UserService service) {
        this.userService = service;
    }

    @Autowired
    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Basket getBasket() {
        return basket;
    }



    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
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

}
