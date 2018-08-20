package com.justas.trainingpartner.controller;

import com.justas.trainingpartner.exception.ResourceNotFoundException;
import com.justas.trainingpartner.model.User;
import com.justas.trainingpartner.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
    }
}