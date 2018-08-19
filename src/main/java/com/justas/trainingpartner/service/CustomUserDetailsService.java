package com.justas.trainingpartner.service;

import com.justas.trainingpartner.model.User;
import com.justas.trainingpartner.repository.UserRepository;
import com.justas.trainingpartner.security.UserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username + "."));

        return UserPrincipal.create(user);
    }

    // This method is used by JWTAuthenticationFilter.

    public UserDetails loadUserById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found with ID: " + id + "."));

        return UserPrincipal.create(user);
    }
}