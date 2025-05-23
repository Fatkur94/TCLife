package com.techcombank.tclife.common.client;

import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class GlobalFeignClientConfig {

    @Value("${integration.portal.secret-key.value}")
    private String secretKeyValue;

    @Value("${integration.portal.connect-timeout:10000}")
    private Integer connectTimeout;

    @Value("${integration.portal.read-timeout:10000}")
    private Integer readTimeout;

    @Bean
    public RequestInterceptor internalInterceptor() {
        return requestTemplate -> requestTemplate.header("X-Secret-Key", secretKeyValue);
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new FeignErrorDecoder();
    }
}

