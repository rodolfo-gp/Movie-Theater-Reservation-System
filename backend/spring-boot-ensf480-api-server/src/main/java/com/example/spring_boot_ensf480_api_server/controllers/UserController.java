package com.example.spring_boot_ensf480_api_server.controllers;

import java.util.Optional;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.spring_boot_ensf480_api_server.models.User;
import com.example.spring_boot_ensf480_api_server.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Add a new user (sign up)
    @PostMapping("/signup")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        if (userRepository.existsById(user.getEmail())) {
            return ResponseEntity.badRequest().body("Error: Email is already registered.");
        }
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    

    @PutMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, String> loginInfo) {
        String email = loginInfo.get("email");
        String password = loginInfo.get("password");

        Optional<User> userOptional = userRepository.findByEmailAndPassword(email, password);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Map<String, String> response = new HashMap<>();
            response.put("message", "Successful login");
            response.put("firstName", user.getFirstName());
            response.put("lastName", user.getLastName());
            return ResponseEntity.ok(response);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Incorrect login info");
            return ResponseEntity.status(401).body(errorResponse);
        }
    }
}
