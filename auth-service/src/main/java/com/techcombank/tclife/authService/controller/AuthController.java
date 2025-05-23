package com.techcombank.tclife.authService.controller;

import com.techcombank.tclife.authService.model.request.LoginRequest;
import com.techcombank.tclife.authService.model.request.RegisterRequest;
import com.techcombank.tclife.authService.model.response.AuthResponse;
import com.techcombank.tclife.authService.service.CognitoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth-service")
@AllArgsConstructor
public class AuthController {

    private final CognitoService cognitoService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        boolean result = cognitoService.registerUser(request);
        return ResponseEntity.ok(new AuthResponse(result, result ? "User registered successfully." : "Registration failed.", null, false));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(cognitoService.loginUser(request));
    }
}
