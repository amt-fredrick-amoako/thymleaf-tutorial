package com.springsecurity.labs.thymeleaftutorial.controller;

import com.springsecurity.labs.thymeleaftutorial.model.League;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String home(Model model){
       model.addAttribute("home", new League("NFL", "National Football League"));
       return "index";
    }
}
