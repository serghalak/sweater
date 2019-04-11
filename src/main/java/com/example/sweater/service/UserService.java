package com.example.sweater.service;


import com.example.sweater.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    private UserRepo userRepo;

}
