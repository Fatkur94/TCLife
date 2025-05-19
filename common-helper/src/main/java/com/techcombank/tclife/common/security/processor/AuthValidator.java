package com.techcombank.tclife.common.security.processor;

import com.techcombank.tclife.common.exception.BusinessException;
import com.techcombank.tclife.common.security.model.ApiAccessScope;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AuthValidator {

    @Value("${integration.portal.secret-key.value:defaultValue}")
    private String portalSecretKey;

    public void validate(ApiAccessScope[] scopes, HttpServletRequest request) {
        boolean authorized = Arrays.stream(scopes).anyMatch(scope -> switch (scope) {
            case INTERNAL -> validateSecretKey(request);
            case SALES -> validateRole(request, "SALES");
            case CUSTOMER -> validateRole(request, "CUSTOMER");
        });

        if (!authorized) {
            throw new BusinessException(HttpStatus.UNAUTHORIZED, "4010000","Unauthorized: invalid token or credentials", "Unauthorized");
        }
    }

    private boolean validateSecretKey(HttpServletRequest request) {
        String key = request.getHeader("X-Secret-Key");
        return portalSecretKey.equals(key);
    }

    private boolean validateRole(HttpServletRequest request, String role) {
        String auth = request.getHeader("Authorization");
//        String token = auth.substring(7); // decode jwt TBD
        return auth != null && auth.startsWith("Bearer ");
    }
}

