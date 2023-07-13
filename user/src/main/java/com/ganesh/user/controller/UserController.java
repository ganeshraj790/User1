package com.ganesh.user.controller;


import com.ganesh.user.service.UserService;
import com.ganesh.user.userEntity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService service;


    @PostMapping(value="/adduser")
    public ResponseEntity<User> createUser(@RequestBody  User user){
        User saveUser =service.createUser(user);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
    }

    @GetMapping(value="/getallusers")
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }


    @DeleteMapping(value="delete/{id}")
    public String deleteUser(@PathVariable("id")int id){
        return service.deleteUser(id);
    }

    @GetMapping(value="getuser/{id}")
    public User getUserById(@PathVariable("id")int id){
        return service.getUserById(id);
    }

    @PutMapping(value="/update/{id}")
    public String updateUser(@PathVariable("id") int id, @RequestBody User user){
        return service.updateUser(id, user);
    }
}
