package com.nozama.aluguel_veiculos.controllers;

import com.nozama.aluguel_veiculos.domain.user.User;
import com.nozama.aluguel_veiculos.dto.UserRequest;
import com.nozama.aluguel_veiculos.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest) {
        try {
            User user = userService.create(userRequest);
            return ResponseEntity.status(201).body(user);
        } catch (Exception e){
            return ResponseEntity.status(400).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getUsers();
        return ResponseEntity.status(200).body(users);
    }
}