package com.techcombank.tclife.authService.service;

public interface AuthorizationService {
    boolean isAuthorized(String bearerToken, String resource, String action);
}