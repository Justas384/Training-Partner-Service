package com.justas.trainingpartner.controller;

import com.justas.trainingpartner.exception.ResourceNotFoundException;
import com.justas.trainingpartner.model.User;
import com.justas.trainingpartner.payload.UserIdentityAvailability;
import com.justas.trainingpartner.payload.UserSummary;
import com.justas.trainingpartner.repository.UserRepository;
import com.justas.trainingpartner.security.CurrentUser;
import com.justas.trainingpartner.security.UserPrincipal;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("user/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return new UserSummary(userPrincipal.getId(), userPrincipal.getName(), userPrincipal.getUsername(), userPrincipal.getEmail());
    }

    @GetMapping("/user/checkUsernameAvailability")
    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
        Boolean isAvailable = !userRepository.existsByUsername(username);

        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/user/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
        Boolean isAvailable = !userRepository.existsByEmail(email);

        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("users/{id}")
    public User getUser(@PathVariable int id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "ID", id));
    }
}