package com.techcombank.tclife.common.context;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PortalContext {
    private HttpHeaders httpHeaders;
    private String customerId;
    private String otpNo;
    private String deviceId;
    private String authorization;
    private String language;
    private String requestId;
    private String userAgent;
    private String platform;
    private String channelId;
    private String apiKey;
    private String userId;
    private String clientId;
    private String clientSecret;
    private String secretKey;
    private String signature;
    private String traceId;
    private String spanId;
}
