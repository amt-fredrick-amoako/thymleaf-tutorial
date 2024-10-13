package com.springsecurity.labs.thymeleaftutorial.controller;

import com.springsecurity.labs.thymeleaftutorial.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    // handler method to handle variable expression request

    @GetMapping("variable-expression")
    public String variableExpression(Model model) {
        model.addAttribute("user", new User("male", "ADMIN", "fredrick.amoako@amalitech.com", "fredrick amoako"));
        return "variable-expression";
    }
}
