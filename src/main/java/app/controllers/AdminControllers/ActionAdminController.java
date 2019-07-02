package app.controllers.AdminControllers;


import app.Service.UserService;
import app.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class ActionAdminController {

    private UserService service;

    @Autowired
    public ActionAdminController(UserService service) {
        this.service = service;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String seeALl(Model model){
       model.addAttribute("usersList", service.getAll());
       return "AdminPage";
    }
}
