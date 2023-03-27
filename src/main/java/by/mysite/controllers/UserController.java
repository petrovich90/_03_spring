package by.mysite.controllers;

import by.mysite.model.entities.User;
import by.mysite.model.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static by.mysite.constants.AppConstants.*;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = ALL_USERS_URL)
    public String getAll(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute(USERS_LIST_ATTRIBUTE, users);
        return USERS_PAGE;
    }
}
