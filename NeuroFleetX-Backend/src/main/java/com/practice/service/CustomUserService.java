package com.practice.service;

import com.practice.entity.Role;
import com.practice.entity.User;
import com.practice.repository.RoleRepository;
import com.practice.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserService {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService; // assuming you have JwtService

    public CustomUserService(UserRepository userRepo, RoleRepository roleRepo, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String register(String name, String email, String password, String roleName) {
        if (userRepo.findByEmail(email).isPresent()) {
            return "User already exists!";
        }

        Role role = roleRepo.findByName(roleName)
                .orElseGet(() -> roleRepo.save(new Role(null, roleName)));

        User user = new User(null, name, email, passwordEncoder.encode(password), role);
        userRepo.save(user);

        return "User registered successfully with role: " + roleName;
    }

    public String login(String email, String password) {
        Optional<User> userOpt = userRepo.findByEmail(email);
        if (userOpt.isEmpty()) return "Invalid email or password";

        User user = userOpt.get();
        if (!passwordEncoder.matches(password, user.getPassword())) {
            return "Invalid email or password";
        }

        return jwtService.generateToken(user.getEmail(), user.getRole().getName());
    }
}
