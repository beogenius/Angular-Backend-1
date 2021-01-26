package com.bacsihai.springbootbackend.controller;


import com.bacsihai.springbootbackend.model.IDS;
import com.bacsihai.springbootbackend.model.User;
import com.bacsihai.springbootbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public Iterable<User> getALlUser(){
        return userService.getAllUser();
    }

    @PostMapping("/create")
    public User save(@RequestBody User user){
      return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id){
        return userService.getUserByID(id);
    }

    @PostMapping("/deleteall")
    public void deleteAll(@RequestBody IDS ids){
        userService.deleteAll(ids.getIds());
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id,@RequestBody User userdetail){
        User user = userService.getUserByID(id);
        user.setFirstName(userdetail.getFirstName());
        user.setLastName(userdetail.getLastName());
        user.setEmail(userdetail.getEmail());
        user.setMobile(userdetail.getMobile());
        user.setSalary(userdetail.getSalary());

        User userUpdated = userService.saveUser(user);
        return ResponseEntity.ok(userUpdated);
    }
}

