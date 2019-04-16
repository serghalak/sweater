package com.example.sweater.controller;

import com.example.sweater.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.sweater.domain.User;
@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model){
        System.out.println("User: "+user);
        if(!userService.addUser(user)) {
            model.addAttribute("message",
                    "User " + user.getUsername() + " is exists!!!");
             return "registration";
        }
        return "redirect:/login";
    }
}
