package com.example.sweater.service;


import com.example.sweater.domain.Role;
import com.example.sweater.domain.User;
import com.example.sweater.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public boolean addUser(User user){
        User userFromDb=userRepo.findByUsername(user.getUsername());
        if(userFromDb !=null){
            return false;
        }else{
            user.setActive(true);
            user.setRoles(Collections.singleton(Role.USER));
            userRepo.save(user);
        }
        return true;
    }

}
