package com.dio.apirestexample.apirestexample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.dio.apirestexample.apirestexample.services.UserService;
import com.dio.apirestexample.apirestexample.models.User;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;
    @PostMapping("/users")
    public void postUser(@RequestBody User user){
        service.createUser(user);
    }
    //@GetMapping("/users/{username}")
    //public void getOneUser() {}
}
