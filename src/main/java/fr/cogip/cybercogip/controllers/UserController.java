package fr.cogip.cybercogip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/createUser")
    public String createUser(Model model){
        return "createUser";
    }
}
