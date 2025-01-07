package com.auth.Authentication.security;

<<<<<<< HEAD
import com.auth.Authentication.Services.UserService;
import com.auth.Authentication.dto.LoginRequest;
import com.auth.Authentication.entity.User;
=======
>>>>>>> main
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
=======
>>>>>>> main
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

<<<<<<< HEAD
    @Autowired
    private UserService userDetailsService;

=======
// You may also need to inject your UserDetailsService or other services here.
>>>>>>> main

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
<<<<<<< HEAD

            if (jwtTokenProvider.validateToken(token)) {
                String email = jwtTokenProvider.getEmailFromToken(token);

                User userDetails = userDetailsService.findUserByEmail(email);

                // No need to get password from request, as it's already authenticated when the JWT was created
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, null); // userDetails.getAuthorities() for roles

                // Set the authentication object in the security context
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                System.out.println("Token validation failed");
=======
            if (jwtTokenProvider.validateToken(token)) {
                String username = jwtTokenProvider.getUsernameFromToken(token);
                // Load user details and set authentication in the security context.
>>>>>>> main
            }
        }

        filterChain.doFilter(request, response);
    }
<<<<<<< HEAD

}
=======
}
>>>>>>> main
