package com.aditiyaa.campus_recruitment.controller;

import com.aditiyaa.campus_recruitment.dto.ApiResponse;
import com.aditiyaa.campus_recruitment.dto.RegisterRequest;
import com.aditiyaa.campus_recruitment.model.User;
import com.aditiyaa.campus_recruitment.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// controller/AuthController.java
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(
            @Valid @RequestBody RegisterRequest request) {

        User user = userService.register(request);
        return ResponseEntity.ok(
                ApiResponse.ok("Registration successful", Map.of(
                        "id", user.getId(),
                        "email", user.getEmail(),
                        "role", user.getRole()
                ))
        );

    }
}
