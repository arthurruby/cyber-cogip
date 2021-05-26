package fr.cogip.cybercogip.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @RequestMapping("/hello")
    public @ResponseBody String greeting() {
        return "Hello, World";
    }
}
