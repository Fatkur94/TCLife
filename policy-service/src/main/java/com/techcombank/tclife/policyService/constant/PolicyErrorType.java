package com.techcombank.tclife.policyService.constant;

import org.springframework.http.HttpStatus;
import com.techcombank.tclife.common.exception.ErrorDefinition;
import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public enum PolicyErrorType implements ErrorDefinition {
    // Business Exception
    INVALID_POLICY(HttpStatus.BAD_REQUEST, "4000301", "ERROR_INVALID_POLICY", "Invalid policy data", ""),
    POLICY_NOT_FOUND(HttpStatus.NOT_FOUND, "4040301", "ERROR_POLICY_NOT_FOUND", "Policy not found", ""),
    DUPLICATE_POLICY(HttpStatus.CONFLICT, "4090301", "ERROR_DUPLICATE_POLICY", "Policy already exists", "Duplicate entry in database"),
    // Technical Exception
    AUTHENTICATION_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "5000301", "ERROR_AUTHENTICATION", "Authentication service failure", "Token validation failed"),
    CACHE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "5000302", "ERROR_CACHE", "Cache service unavailable", "Redis connection lost"),
    PARSE_DATE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "5000303", "ERROR_PARSE_DATE", "Failed to parse date.", "");

    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String errorDesc;
    private final String errorMessage;
    private final String rootCause;
}
