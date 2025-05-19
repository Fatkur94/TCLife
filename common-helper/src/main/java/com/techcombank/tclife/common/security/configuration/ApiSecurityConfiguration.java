package com.techcombank.tclife.common.security.configuration;

import com.techcombank.tclife.common.security.interceptor.AuthInterceptor;
import com.techcombank.tclife.common.security.processor.AuthValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiSecurityConfiguration {

    @Bean
    public AuthValidator authValidator() {
        return new AuthValidator();
    }

    @Bean
    public AuthInterceptor tokenInterceptor(AuthValidator authValidator) {
        return new AuthInterceptor(authValidator);
    }
}
