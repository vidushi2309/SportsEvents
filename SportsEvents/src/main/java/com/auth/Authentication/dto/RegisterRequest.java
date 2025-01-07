package com.auth.Authentication.dto;

public class RegisterRequest {
<<<<<<< HEAD
    private String name;
=======
    private String username;
>>>>>>> main
    private String email; // New field for email
    private String password;
    private String role; // Role can be "COACH", "ATHLETE", or "ADMIN"

<<<<<<< HEAD
    // Getters and Setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
=======
    // Getters and Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
>>>>>>> main
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}