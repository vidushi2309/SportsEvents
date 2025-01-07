package com.auth.Authentication.config;

import com.auth.Authentication.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
<<<<<<< HEAD
import org.springframework.context.annotation.Lazy;
=======
>>>>>>> main
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
<<<<<<< HEAD
    @Lazy // Break the circular dependency
=======
>>>>>>> main
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
<<<<<<< HEAD
        return new BCryptPasswordEncoder();
=======
        return new BCryptPasswordEncoder(); // Use BCrypt for password encoding
>>>>>>> main
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
<<<<<<< HEAD
                .cors() // Enable CORS support if needed
                .and()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll() // Allow public access to auth endpoints
                        .requestMatchers("/api/events/**").permitAll() // Allow public access to events (viewing)
                        .requestMatchers("/api/user/event_register/**").permitAll() // Only ATHLETE can register for event
                        .anyRequest().authenticated()) // All other requests require authentication
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class); // Add JWT filter before username/password auth
=======
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll()
                        .anyRequest().authenticated())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
>>>>>>> main

        return http.build();
    }
}