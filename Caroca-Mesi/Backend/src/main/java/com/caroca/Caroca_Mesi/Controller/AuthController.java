package com.caroca.Caroca_Mesi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.caroca.Caroca_Mesi.Services.UserService;
import com.caroca.Caroca_Mesi.Model.User;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        if (userService.findByEmail(user.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Email already exists");
        }
        user.setRole("USER");
        userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User found = userService.findByEmail(user.getEmail());
        if (found != null && userService.checkPassword(user.getPassword(), found.getPassword())) {            // For demo: return user info (in production, return JWT)
            return ResponseEntity.ok(found);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }
}
