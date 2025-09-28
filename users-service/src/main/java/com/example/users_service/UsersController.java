package com.example.users_service;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    /* TODO
    - Need to edit RequestBody or change to new Annotation to only request email and pwd
    - Add basic Validation for all Features
    - ADD basic tests (Junit/ErrorHandling)
    - Add id, name, email etc... check's
    */

    // Basic Counter used for ID's
    private Long idCount = 1L;

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
        // Screw the nested loops and errors - user cannot enter ID - still prompts for ID, but works!
        user.setId(idCount++);
        users.add(user);
        return user;
    }

    // POST Request to add Multiple Users
    @PostMapping("/addUsers")
    public List<Users> addUsers(@Valid @RequestBody List<Users> user) {
        for (Users u : user) {
            u.setId(idCount++);
            users.add(u);
        }
        return user;
    }

    // Simple PUT Request to update Users by ID
    @PutMapping("/updateUser/{id}")
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

    // Simple DELETE Request to Delete a User by ID
    @DeleteMapping("/deleteUser/{id}")
    public Users deleteUser(@Valid @RequestParam Long id){
        users.removeIf(u -> u.getId().equals(id)); // Auto generated in IntelliJ, from nested loop to using 'CollectionIf' + actually works
        return null;
    }

}