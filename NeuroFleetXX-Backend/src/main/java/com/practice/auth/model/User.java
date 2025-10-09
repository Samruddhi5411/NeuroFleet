package com.practice.auth.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private String role;

    // ✅ Default constructor
    public User() {
    }

    // ✅ Getters and Setters (these fix your error)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {   // ✅ this line removes your error
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {   // ✅ same for password
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {           // ✅ and role
        this.role = role;
    }
}
