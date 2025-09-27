package com.example.users_service;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    /* TODO    
    - Add all CRUD Features (Update: PUT/POST, Delete: DELETE)
    - Add basic Validation for all Features
    - ADD basic tests (Junit/ErrorHandling)
    */

    // Create In-Memory Storage for List of Users
    List<Users> users = new ArrayList<>();

    // GET Request to return list of all Users
    @GetMapping("/listUsers")
    public List<Users> getUser(){
        return users;
    }

    // POST Request to add One User
    @PostMapping("/addUser")
    public Users addUser(@Valid @RequestBody Users user){
        users.add(user);
        return user;
    }

    // POST Request to add Multiple Users
    @PostMapping("/addUsers")
    public List<Users> addUsers(@Valid @RequestBody List<Users> user){
        users.addAll(user);
        return users;
    }

    // Simple Get method to return count of Users
    @GetMapping("/countUsers")
    public int getCountUsers(){
        return users.size();
    }

}