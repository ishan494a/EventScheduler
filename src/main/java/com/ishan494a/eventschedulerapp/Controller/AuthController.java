package com.ishan494a.eventschedulerapp.Controller;

import com.ishan494a.eventschedulerapp.DTO.LoginUserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/auth")
public class AuthController {
    @GetMapping("/test")
    public String test() {
        return "TEST";
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody LoginUserDTO userDTO) {
        // TODO: Add logic to handle user registration, e.g., saving the user to a database

        return ResponseEntity.ok(Arrays.asList("User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginUserDTO userDTO) {
        // TODO: Add logic to handle user authentication
        
        return ResponseEntity.ok(Arrays.asList("Login successful"));
    }

}
