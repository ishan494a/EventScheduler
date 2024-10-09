package com.ishan494a.eventschedulerapp.Controller;

import com.ishan494a.eventschedulerapp.DTO.UserAccountDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/auth")
public class HomeController {
    @GetMapping("/secured")
    public String secured() {
        return "This is a secured page";
    }
    @PostMapping("/register")
    public ResponseEntity<UserAccountDTO> registerUser(@RequestBody UserAccountDTO userAccountDTO) {
        // Implement the logic to save user to the database or validate the input
        // For example, you can call a service to handle the registration logic
        // Example: userService.register(userDTO);


        return ResponseEntity.ok(userAccountDTO);
    }
    @PostMapping("/login")
    public ResponseEntity<UserAccountDTO> loginUser(@RequestBody UserAccountDTO userAccountDTO) {
        // Implement the logic to save user to the database or validate the input
        // For example, you can call a service to handle the registration logic
        // Example: userService.register(userDTO);


        return ResponseEntity.ok(userAccountDTO);
    }
}
