package app.controllers.FormControllers;


import app.Service.FlowerService.FlowerService;
import app.Service.UserService.UserService;
import app.models.User.Roles;
import app.models.User.User;
import app.vallidation.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

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
                                RedirectAttributes redirectAttributes, HttpSession session){

        User currentUser = validator.findByUsername(username,service.getAll());

        if(currentUser == null || !(currentUser.getPassword().equals(password))){
            redirectAttributes.addFlashAttribute("informationMessage",
                                                 "Wrong username or password!!");
            return "redirect:/web/signIn";
        }

        session.setAttribute("currentUser",currentUser );


        if(currentUser.getRole().equals(Roles.ADMIN))
                       return "redirect:/web/admin";

      //  redirectAttributes.addFlashAttribute("user", new User(username,null, Roles.USER));
      //  redirectAttributes.addFlashAttribute("flowerList", flowerService.getAllFlowers());
        return "redirect:/web/userPage";
    }

}
