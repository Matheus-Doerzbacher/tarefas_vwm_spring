package com.example.tarefas_vwm.controller;

import com.example.tarefas_vwm.model.User;
import com.example.tarefas_vwm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        Optional<User> authenticatedUser = userService.authenticate(user.getEmail(), user.getPassword());
        return authenticatedUser
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

// http://localhost:8080/api/auth/login
