package com.techcombank.tclife.claimService.constant;

import com.techcombank.tclife.common.exception.ErrorDefinition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ClaimErrorType implements ErrorDefinition {
    // Business Exception
    GENERAL_CONFLICT(HttpStatus.CONFLICT, "4090200", "GENERAL_ERROR_CONFLICT", "Conflict", ""),
    // Technical Exception
    PARSE_DATE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "5000303", "ERROR_PARSE_DATE", "Failed to parse date.", "test");

    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String errorDesc;
    private final String errorMessage;
    private final String rootCause;
}
