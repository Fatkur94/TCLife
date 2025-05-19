package com.techcombank.tclife.common.security.interceptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techcombank.tclife.common.security.annotation.ApiMiddleware;
import com.techcombank.tclife.common.security.model.ApiAccessScope;
import com.techcombank.tclife.common.security.processor.AuthValidator;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.aspectj.lang.annotation.Aspect;

import java.lang.reflect.Method;
import java.util.Arrays;

@Slf4j
@Aspect
public class AuthInterceptor {

    private final AuthValidator authValidator;

    public AuthInterceptor(AuthValidator authValidator) {
        this.authValidator = authValidator;
    }

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    private void restController() {
    }

    @Pointcut("@annotation(com.techcombank.tclife.common.security.annotation.ApiMiddleware)")
    private void apiMiddlewareAnnotated() {
    }

    @Before("restController() && apiMiddlewareAnnotated()")
    public void validate(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        ApiMiddleware annotation = method.getAnnotation(ApiMiddleware.class);
        if (annotation == null) {
            annotation = method.getDeclaringClass().getAnnotation(ApiMiddleware.class);
        }

        if (annotation == null) return;

        ApiAccessScope[] scopes = annotation.scope();

        log.info("Validating scopes: {}", Arrays.toString(scopes));
        authValidator.validate(scopes, request);
        log.info("Successfully validate scopes: {}", Arrays.toString(scopes));
    }

}
