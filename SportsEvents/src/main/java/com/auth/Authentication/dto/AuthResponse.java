package com.auth.Authentication.dto;

public class AuthResponse {
    private String token;
    private String message;
<<<<<<< HEAD
    public String role;
    private Long roleId;

    public AuthResponse(String token, String message, String role, Long roleId) {
        this.token = token;
        this.message = message;
        this.role = role;
        this.roleId = roleId;
=======

    public AuthResponse(String token, String message) {
        this.token = token;
        this.message = message;
>>>>>>> main
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
<<<<<<< HEAD

    public String getRole(){ return role;}

    public void setRole(String role) {this.role = role;}

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
=======
>>>>>>> main
}