package com.example.Learn.controller;

import com.example.Learn.exception.UserNotFoundException;
import com.example.Learn.model.Users;
import com.example.Learn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    Users newUser(@RequestBody Users newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<Users> getAllUsers(){
        return userRepository.findAll();
    }
    @GetMapping("/users/{id}")
    Users getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));


    }




}
