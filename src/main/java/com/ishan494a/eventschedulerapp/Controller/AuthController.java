package com.ishan494a.eventschedulerapp.Controller;

import com.ishan494a.eventschedulerapp.DTO.LoginUserDTO;
import com.ishan494a.eventschedulerapp.Entity.UserAccount;
import com.ishan494a.eventschedulerapp.Service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {
    private final UserAccountService userAccountService;

    @Autowired
    public AuthController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }
    @GetMapping("/test")
    public String test() {
        return "TEST";
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody LoginUserDTO userDTO) {
        // TODO: Add logic to handle user registration, e.g., saving the user to a database
        if (userAccountService.userExists(userDTO.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists.");
        }
        userAccountService.registerUser(userDTO.getEmail(), userDTO.getPassword());
        return ResponseEntity.ok(Arrays.asList("User registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginUserDTO userDTO) {
        Optional<UserAccount> optionalUser = userAccountService.findUserByEmail(userDTO.getEmail());

        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(404).body("User not found."); // User does not exist
        }

        UserAccount user = optionalUser.get();
        if (!userAccountService.validatePassword(userDTO.getPassword(), user.getPassword())) {
            return ResponseEntity.status(401).body("Invalid password."); // Invalid password
        }
        return ResponseEntity.ok(user); // Send user data if found
    }

}

