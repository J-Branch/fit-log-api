package io.github.J_Branch.fit_log_api.controller;

import io.github.J_Branch.fit_log_api.dto.LoginRequest;
import io.github.J_Branch.fit_log_api.entity.User;
import io.github.J_Branch.fit_log_api.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login") 
    public String login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }
}
