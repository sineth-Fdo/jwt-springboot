package com.example.jwt_test.controller;

import com.example.jwt_test.dto.UserDto;
import com.example.jwt_test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private  UserService userService;


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Validated @RequestBody UserDto userRequest) {
        try {

            userService.registerUser(userRequest);
            return ResponseEntity.ok("User Registered Successfully.");

        }catch (Exception e) {
            return ResponseEntity.badRequest().body("User Registration Failed." + e.getMessage());

        }
    }
}
