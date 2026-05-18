package io.github.J_Branch.fit_log_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class TestController {
    
    @GetMapping("/test")
    public String test() {
        return "You made your first endpoint!";
    }
    
}
