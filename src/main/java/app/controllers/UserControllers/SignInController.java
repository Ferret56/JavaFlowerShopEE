package app.controllers.UserControllers;


import app.Service.UserService;
import app.models.User.User;
import app.vallidation.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SignInController {

    private UserService service;
    private UserValidator validator = new UserValidator();

    public SignInController(UserService service) {
        this.service = service;
    }

   /* @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public ModelAndView confirmSignIn(@RequestParam("username")String username,
                                      @RequestParam("password")String password,
                                      RedirectAttributes redirectAttributes){

        User user = validator.findByUsername(username,service.getAll());
        if(user == null || !(user.getPassword().equals(password)))
            return new ModelAndView(new RedirectView("redirect:/register"));

       // model.addAttribute("informationMessage","WRONG!");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("UserPage");
        modelAndView.addObject("user",new User(username,null));
        return modelAndView;
    }
*/


    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String confirmSignIn(@RequestParam("username")String username,
                                      @RequestParam("password")String password,
                                      RedirectAttributes redirectAttributes){

        User user = validator.findByUsername(username,service.getAll());
        if(user == null || !(user.getPassword().equals(password))){
            redirectAttributes.addFlashAttribute("informationMessage",
                                                 "Wrong username or password!!");
            return "redirect:/web/signIn";
        }

        redirectAttributes.addFlashAttribute("user", new User(username,null));
        return "redirect:/web/admin";
    }

}
