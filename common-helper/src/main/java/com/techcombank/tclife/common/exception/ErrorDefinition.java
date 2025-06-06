package com.techcombank.tclife.common.exception;

import org.springframework.http.HttpStatus;

public interface ErrorDefinition {
    HttpStatus getHttpStatus();
    String getErrorCode();
    String getErrorDesc();
    String getErrorMessage();
    default String getRootCause() {
        return "";
    }
}
