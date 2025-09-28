package com.example.users_service;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    - Add id, name, email etc... check's
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
        // Nested loop to search through List of Users, and checks if new ID being added already exists
        // throws a big scary red error but will work for now
        // Similar logic should hopefully work for other checks like email name etc...
        for(Users u : users){
            if(u.getId().equals(user.getId())){
                throw new RuntimeException("ID Already Exists");
            }
        }
        users.add(user);
        return user;
    }

    // POST Request to add Multiple Users
    // TODO: error with this method - not working as it should
    @PostMapping("/addUsers")
    public List<Users> addUsers(@Valid @RequestBody List<Users> user){
        for(Users u : user){
            if(u.getId().equals(user.get(0).getId())){
                throw new RuntimeException("ID Already Exists, sorry... :(");
            }
        }
        users.addAll(user);
        return users;
    }

    // Simple Get method to return count of Users
    @GetMapping("/countUsers")
    public int getCountUsers(){
        return users.size();
    }

    // Simple PUT Request to update Users
    @PutMapping("/updateUser")
    public Users updateUser(@Valid @RequestBody Users user,@RequestParam Long id ){
        for(Users u : users) {
            if (u.getId().equals(id)) {
                u.setEmail(user.getEmail());
                u.setPassword(user.getPassword());
                return u;
            }
        }
        return null;
    }

    @DeleteMapping("/deleteUser/{id}")
    public Users deleteUser(@Valid @RequestParam Long id){
        // possibly same as idea as update, take in ID and search for same ID, then DELETE that user
        users.removeIf(u -> u.getId().equals(id)); // Auto generated in IntelliJ, from nested loop to using 'CollectionIf' + actually works
        return null;
    }

}