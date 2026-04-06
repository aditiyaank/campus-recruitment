package com.aditiyaa.campus_recruitment.service;

import com.aditiyaa.campus_recruitment.dto.RegisterRequest;
import com.aditiyaa.campus_recruitment.model.User;
import com.aditiyaa.campus_recruitment.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Use the name 'register' because that's what your AuthController calls
    public User register(@Valid RegisterRequest request) {
        // 1. Check if email is already taken
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email is already registered!");
        }

        // 2. Create new User object
        User user = new User();
        user.setEmail(request.getEmail());

        // 3. Encrypt the password before saving!
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        // 4. Save to MySQL
        return userRepository.save(user);
    }
}