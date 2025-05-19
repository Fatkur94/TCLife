package com.techcombank.tclife.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.ResourceAccessException;

import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(BusinessException ex) {
        return ResponseEntity
                .status(ex.getHttpStatus())
                .body(buildErrorResponse(ex));
    }

    @ExceptionHandler(TechnicalException.class)
    public ResponseEntity<Object> handleTechnicalException(TechnicalException ex) {
        return ResponseEntity
                .status(ex.getHttpStatus())
                .body(buildErrorResponse(ex));
    }

    @ExceptionHandler(ResourceAccessException.class)
    public ResponseEntity<Object> handleResourceAccessException(ResourceAccessException ex) {
        if (ex.getCause() instanceof SocketTimeoutException) {
            return ResponseEntity
                    .status(HttpStatus.GATEWAY_TIMEOUT)
                    .body(buildErrorResponse(ex, "5040000", "GATEWAY_TIMEOUT", "Error communicating with external service"));
        }
        return ResponseEntity
                .status(HttpStatus.GATEWAY_TIMEOUT)
                .body(buildErrorResponse(ex, "5000000", "SERVICE_TIMOUT", "An unexpected error occurred"));
    }

    private Map<String, Object> buildErrorResponse(BaseException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", ex.getSuccess());
        response.put("errorCode", ex.getErrorCode());
        response.put("errorType", ex.getErrorType());
        response.put("errorMessage", ex.getErrorMessage());
        return response;
    }

    private Map<String, Object> buildErrorResponse(ResourceAccessException ex, String errorCode, String errorType, String errorMessage) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", false);
        response.put("errorCode", errorCode);
        response.put("errorType", errorType);
        response.put("errorMessage", errorMessage);
        return response;
    }
}

