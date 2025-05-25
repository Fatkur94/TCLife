package com.techcombank.tclife.authService.controller;

import com.techcombank.tclife.authService.model.request.AccessRequest;
import com.techcombank.tclife.authService.model.request.LoginRequest;
import com.techcombank.tclife.authService.model.request.RegisterRequest;
import com.techcombank.tclife.authService.model.response.AuthResponse;
import com.techcombank.tclife.authService.service.AuthorizationService;
import com.techcombank.tclife.authService.service.CognitoService;
import com.techcombank.tclife.common.wrapper.ClientResponseWrapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final CognitoService cognitoService;
    private final AuthorizationService authorizationService;

    @PostMapping("/register")
    public ResponseEntity<ClientResponseWrapper<Void>> register(@RequestBody RegisterRequest request) {
        try {
            boolean result = cognitoService.registerUser(request);

            if (result) {
                return ResponseEntity.ok(
                        new ClientResponseWrapper<>(true, "User registered successfully.", null)
                );
            } else {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(new ClientResponseWrapper<>(false, "Registration failed.", null));
            }

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ClientResponseWrapper<>(false, "Error during registration: " + e.getMessage(), null));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<ClientResponseWrapper<AuthResponse>> login(@RequestBody LoginRequest request) {
        try {
            AuthResponse response = cognitoService.loginUser(request);

            if (response.isSuccess()) {
                return ResponseEntity.ok(new ClientResponseWrapper<>(true, response.getMessage(), response));
            } else {
                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body(new ClientResponseWrapper<>(false, response.getMessage(), response));
            }

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ClientResponseWrapper<>(false, "Error during login: " + e.getMessage(), null));
        }
    }


    // TODO : need to cache this
    @PostMapping("/authorize")
    public ResponseEntity<ClientResponseWrapper<Void>> authorize(
            @RequestHeader("Authorization") String bearerToken,
            @Valid @RequestBody AccessRequest accessRequest
    ) {
        boolean authorized = authorizationService.isAuthorized(
                bearerToken,
                accessRequest.getResource(),
                accessRequest.getAction()
        );

        if (authorized) {
            return ResponseEntity.ok(
                    new ClientResponseWrapper<>(true, "Access granted", null)
            );
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(new ClientResponseWrapper<>(false, "Access denied", null));
        }
    }
}