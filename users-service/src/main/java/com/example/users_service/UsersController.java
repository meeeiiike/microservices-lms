package com.example.users_service;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UsersController {

    @GetMapping("/users")
    public Users getUser(){
        return new Users("meike@gmail.com", "suprsecurepwd");
    }

    @GetMapping("/users/sayHello")
    public String hello(){
        return "hello";
    }
}
