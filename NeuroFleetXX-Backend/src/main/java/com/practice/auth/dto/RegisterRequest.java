package com.practice.auth.dto;

import com.practice.auth.model.Role;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private Role role;
    // Getters and setters
}