package com.techcombank.tclife.authService.service;

import com.techcombank.tclife.authService.model.request.LoginRequest;
import com.techcombank.tclife.authService.model.request.RegisterRequest;
import com.techcombank.tclife.authService.model.response.AuthResponse;

public interface CognitoService {
    boolean registerUser(RegisterRequest request);
    AuthResponse loginUser(LoginRequest request);
}
