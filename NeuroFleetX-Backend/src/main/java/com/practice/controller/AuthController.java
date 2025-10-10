package com.practice.controller;

import com.practice.entity.User;
import com.practice.service.AuthService;
import com.practice.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(AuthService authService, 
                          AuthenticationManager authenticationManager,
                          JwtService jwtService) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        // Authenticate user
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword())
        );

        // ✅ Generate token with name and role
        return jwtService.generateToken(user.getName(), user.getRole().getName());
    }
}
