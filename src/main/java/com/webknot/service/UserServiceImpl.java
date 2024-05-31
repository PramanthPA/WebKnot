package com.webknot.service;

import com.webknot.dto.UserDTO;
import com.webknot.entity.User;
import com.webknot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User signUp(UserDTO userDTO) {
        User existingUser = userRepository.findByUsername(userDTO.getUsername());
        if (existingUser != null) {
            throw new IllegalArgumentException("Username already exists");
        }

        User newUser = new User();
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        // You can set other user properties here if needed
        // For example, newUser.setRole("USER");

        return userRepository.save(newUser);
    }

    @Override
    public String signIn(UserDTO userDTO) {
        User user = userRepository.findByUsername(userDTO.getUsername());
        if (user != null && passwordEncoder.matches(userDTO.getPassword(), user.getPassword())) {
            // Generate and return a JWT token for authentication
            // You can use your preferred method or a library like JWT.io
            return generateJwtToken(user);
        }
        return null; // Return null if authentication fails
    }

    // Method to generate JWT token
    private String generateJwtToken(User user) {
        // Your JWT token generation logic here
        return "JWT_TOKEN"; // Dummy implementation
    }
}
