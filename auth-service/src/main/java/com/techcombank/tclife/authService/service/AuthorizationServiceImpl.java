package com.techcombank.tclife.authService.service;

import com.techcombank.tclife.authService.client.UserDataClient;
import com.techcombank.tclife.common.wrapper.ClientResponseWrapper;
import com.techcombank.tclife.dataService.model.dto.UserAccessDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorizationServiceImpl implements AuthorizationService {

    private final UserDataClient userDataClient;
    private final JwtDecoder jwtDecoder;

    @Override
    public boolean isAuthorized(String bearerToken, String resource, String action) {
        String token = bearerToken.replace("Bearer ", "");

        Jwt jwt;

        try {
            jwt = jwtDecoder.decode(token);
        } catch (JwtException ex) {
            log.warn("Authorization failed: invalid JWT token - {}", ex.getMessage());
            return false;
        }

        UUID cognitoSub;
        try {
            cognitoSub = UUID.fromString(jwt.getSubject());
        } catch (IllegalArgumentException ex) {
            log.warn("Authorization failed: invalid Cognito sub format - {}", jwt.getSubject());
            return false;
        }

        ClientResponseWrapper<UserAccessDTO> userAccesses = userDataClient.getUserByCognitoSub(cognitoSub);
        if (!userAccesses.isSuccess()) {
            log.warn("Authorization failed: unable to retrieve user for cognitoSub {}", cognitoSub);
            return false;
        }

        String expectedPermission = (resource + ":" + action).toLowerCase();
        return userAccesses.getData().getPermissions().stream()
                .map(String::toLowerCase)
                .anyMatch(expectedPermission::equals);
    }
}