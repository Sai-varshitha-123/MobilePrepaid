package com.aits.mobileprepaid.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.aits.mobileprepaid.entity.User;
import com.aits.mobileprepaid.repository.UserRepo;
import com.aits.mobileprepaid.security.JwtUtil;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@Validated  // Enable validation for method parameters
public class AuthController {

    @Autowired private UserRepo userRepo;
    @Autowired private PasswordEncoder encoder;
    @Autowired private JwtUtil jwtUtil;

    // 🔹 Register User
    @PostMapping("/register")
    public ResponseEntity<String> register(@Validated @RequestBody User user) {
        if (userRepo.findByEmail(user.getemail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }
        
        // Encrypt password before saving
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully!");
    }

    // 🔹 Login User
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody User loginUser) {
        // Find user by email
        var user = userRepo.findByEmail(loginUser.getemail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Check if password matches
        if (encoder.matches(loginUser.getPassword(), user.getPassword())) {
            String token = jwtUtil.generateToken(user.getemail());
            return ResponseEntity.ok(Map.of("token", token, "role", user.getRole().name()));
        } else {
            throw new BadCredentialsException("Invalid credentials");
        }
    }
}
