package com.auth.Authentication.security;

<<<<<<< HEAD
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
=======
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys; // Import Keys class
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
>>>>>>> main

@Component
public class JwtTokenProvider {

<<<<<<< HEAD
    private final SecretKey secretKey;
    private final long expirationTime;

    public JwtTokenProvider(
            @Value("${jwt.secret}") String secret,
            @Value("${jwt.expiration}") long expirationTime) {
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.expirationTime = expirationTime;
    }

    // Generate Token
    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(secretKey, SignatureAlgorithm.HS512)
                .compact();
    }

    // Validate Token
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            System.out.println("Invalid token: " + e.getMessage());
=======
    private final SecretKey secretKey; // Use SecretKey instead of String

    public JwtTokenProvider() {
        // Generate a secure key for HS512
        this.secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours expiration time.
                .signWith(secretKey) // Use the generated secret key
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(secretKey) // Use the generated secret key
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
>>>>>>> main
            return false;
        }
    }

<<<<<<< HEAD
    // Extract Username from Token
    public String getEmailFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
=======
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey) // Use the generated secret key
>>>>>>> main
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> main
