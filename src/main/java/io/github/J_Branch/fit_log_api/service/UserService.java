package io.github.J_Branch.fit_log_api.service;

import io.github.J_Branch.fit_log_api.entity.User;
import io.github.J_Branch.fit_log_api.repository.UserRepository;
import io.github.J_Branch.fit_log_api.util.JwtUtil;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import io.github.J_Branch.fit_log_api.dto.LoginRequest;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User register(User user) {
        String hashedPassword = passwordEncoder.encode((user.getPassword()));
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

    public String login(LoginRequest request) {
        Optional<User> optionalUser = userRepository.findByEmail(request.getEmail());

        if (optionalUser.isEmpty()) {
            return "User not found";
        }

        User user = optionalUser.get();

        boolean passWordMatches = passwordEncoder.matches(request.getPassword(), user.getPassword());

        if (!passWordMatches) {
            return "Invalid password";
        }

        return JwtUtil.generateToken(user.getEmail());
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
