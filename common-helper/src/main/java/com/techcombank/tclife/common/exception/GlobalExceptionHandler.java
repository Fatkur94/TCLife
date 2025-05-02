package com.techcombank.tclife.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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

    private Map<String, Object> buildErrorResponse(BaseException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", ex.getSuccess());
        response.put("errorCode", ex.getErrorCode());
        response.put("errorType", ex.getErrorType());
        response.put("errorMessage", ex.getErrorMessage());
        return response;
    }
}

