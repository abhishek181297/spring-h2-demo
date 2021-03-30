package com.example.springh2demo.controller;

import com.example.springh2demo.models.User;
import com.example.springh2demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Long userId) {
        return new ResponseEntity<>(userRepository.getOne(userId), HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<List<User>> getByName(@RequestParam(name = "name") String name) {
        List<User> userList = userRepository.findByName(name);
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestParam(name = "name") String name) {
        User user = new User(name);
        user = userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
