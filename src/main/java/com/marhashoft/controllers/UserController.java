package com.marhashoft.controllers;

import com.marhashoft.models.User;
import com.marhashoft.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getUsers() {
       return userRepository.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
        try {
            User user = userRepository.getUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(Arrays.asList(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping
    public User createUser(@PathVariable("id") Long id) {
        return null;
    }

    @PutMapping
    public User updateUser(@PathVariable("id") Long id) {
        return null;
    }

    @DeleteMapping
    public User deleteUser(@PathVariable("id") Long id) {
        return null;
    }
}
