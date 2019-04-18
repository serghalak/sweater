package com.example.sweater.controller;

import com.example.sweater.domain.Role;
import com.example.sweater.domain.User;
import com.example.sweater.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String listUsers(Model model){
        Iterable<User> users =  userService.userList();
        model.addAttribute("users",users);
        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable(name = "user") User user
        ,Model model){
        //System.out.println("User by id: " + user);
        model.addAttribute("user",user);
        model.addAttribute("roles",Role.values());
        return "userEdit";
    }
    @PostMapping()
    public String userEdit(@RequestParam(name = "id")Long id
            ,@RequestParam Map<String,String> form
            ,@RequestParam String username
            ,Model model){
//        userService.updateUser(user);
//        for (Role role : Role.values()) {
//
//        }

        System.out.println("username: " + username);
        System.out.println("form: " + form);
        User userFromDb = userService.findUserById(id);
        userFromDb.getRoles().clear();
        userFromDb.setUsername(username);
        for(Role role : Role.values()){
            if(form.containsKey(role.name())){
                System.out.println("role: " + role);
                 userFromDb.getRoles().add(role);
            }
        }
        System.out.println("User new "+userFromDb);
        userService.updateUser(userFromDb);
        return "redirect:/user";
    }


}
