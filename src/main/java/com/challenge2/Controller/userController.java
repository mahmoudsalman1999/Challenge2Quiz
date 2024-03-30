package com.challenge2.Controller;

import com.challenge2.Entity.User;
import com.challenge2.Repository.userRepository;
import com.challenge2.Services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {
    @Autowired
    private userService service;
    @Autowired
    private userRepository repository;

    @PostMapping("/login")
    public String login(@RequestBody User request) {
        boolean isAuthenticated = service.authenticate(request.getUsername(), request.getPassword());
        if (isAuthenticated) {
            return "You have been logged in successfully";
        } else {
            return "login failed";
        }
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User registerUser) {
        if (service.findByUsername(registerUser.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username is already taken");
        }
        service.register(registerUser);
        return ResponseEntity.ok("User registered successfully");
    }
}
