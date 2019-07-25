package app.controllers.AdminControllers;


import app.Service.UserService.UserService;
import app.models.User.Roles;
import app.models.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class ViewAdminPageController {

    private UserService service;

    @Autowired
    public ViewAdminPageController(UserService service) {
        this.service = service;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String sendAdminPage(HttpSession session, Model model){
        User currentUser = (User)session.getAttribute("currentUser");
        if( currentUser!=null && currentUser.getRole().equals(Roles.ADMIN)) {
            model.addAttribute("usersList", service.getAll());
            return "pages/AdminPage";
        }
        return "redirect:/web/signIn";
    }
}
