package com.example.sweater.controller;


import com.example.sweater.domain.Message;
import com.example.sweater.domain.User;
import com.example.sweater.service.MessageService;
import com.example.sweater.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private MessageService messageService;

//    @GetMapping("/")
//    public String greeting(
//            @RequestParam(
//                    name="name"
//                        , required=false
//                        , defaultValue="World") String name
//            , Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }

    @GetMapping("/main")
    public String main(

            @RequestParam(name = "filter" ,required = false,defaultValue = "")String filter
            , Model model){
        Iterable<Message> messages=null;
        if(filter==null || filter.equals("") || filter.isEmpty()){
            messages=messageService.list();
        }else{
            messages=messageService.getMessageWithFilter(filter);
        }

        model.addAttribute("messages",messages);
        model.addAttribute("filter",filter);
        System.out.println("--->main: "+messages);
        return "main";
    }
    @PostMapping("/main")
    public String addMessage(
            @AuthenticationPrincipal User user,
            @RequestParam String text
            ,@RequestParam String tag
            ,Model model){
        messageService.add(text,tag,user);
        return "redirect:/main";
    }
}