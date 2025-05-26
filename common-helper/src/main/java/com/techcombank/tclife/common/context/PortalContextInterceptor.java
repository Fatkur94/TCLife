package com.techcombank.tclife.common.context;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Enumeration;
import java.util.List;

@Component
@Slf4j
public class PortalContextInterceptor implements HandlerInterceptor {
    private static final String DEFAULT_LANGUAGE = "en-US";
    private static final String X_AUTHORIZATION = "Authorization";
    private static final String X_USER_AGENT = "User-Agent";
    private static final String X_ACCEPT_LANGUAGE = HttpHeaders.ACCEPT_LANGUAGE;
    private static final String X_OTP_NO = "X-Otp-No";
    private static final String X_PLATFORM = "X-Platform";
    private static final String X_CLIENT_VERSION = "X-Client-Version";
    private static final String X_CHANNEL_ID = "X-Channel-ID";
    private static final String X_API_KEY = "X-API-Key";
    private static final String X_USER_ID = "X-User-ID";
    private static final String X_REQUEST_ID = "X-Request-ID";
    private static final String X_CUSTOMER_ID = "X-Customer-ID";
    private static final String X_CLIENT_ID = "X-Client-ID";
    private static final String X_CLIENT_SECRET = "X-Client-Secret";
    private static final String X_SECRET_KEY = "X-Secret-Key";
    private static final String X_SIGNATURE = "X-SIGNATURE";
    private static final String X_TRACE_ID = "X-Trace-ID";
    private static final String X_SPAN_ID = "X-Span-ID";

    public static final List<String> ALLOW_HEADERS = List
            .of(X_AUTHORIZATION, X_ACCEPT_LANGUAGE, X_REQUEST_ID,
                    X_USER_AGENT, X_OTP_NO, X_PLATFORM, X_CLIENT_VERSION, X_CHANNEL_ID,
                    X_API_KEY, X_USER_ID, X_CUSTOMER_ID, X_CLIENT_ID, X_CLIENT_SECRET,
                    X_SECRET_KEY, X_SIGNATURE, X_TRACE_ID, X_SPAN_ID).stream()
            .map(String::toLowerCase).toList();

    private final ObjectFactory<PortalContext> portalcontextFactory;

    public PortalContextInterceptor(ObjectFactory<PortalContext> portalcontextFactory) {
        this.portalcontextFactory = portalcontextFactory;
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        PortalContext context = portalcontextFactory.getObject();
        HttpHeaders httpHeaders = applyHttpHeaders(request);
        String authentication = httpHeaders.getFirst(X_AUTHORIZATION);

        if (authentication != null) {
            authentication = authentication.replace("Bearer", "");
            authentication = authentication.trim();
        }

        context.setAuthorization(httpHeaders.getFirst(authentication));
        context.setUserId(httpHeaders.getFirst(X_USER_ID));
        context.setRequestId(httpHeaders.getFirst(X_REQUEST_ID));
        context.setUserAgent(httpHeaders.getFirst(X_USER_AGENT));
        context.setLanguage(httpHeaders.getFirst(X_ACCEPT_LANGUAGE));
        context.setClientId(httpHeaders.getFirst(X_CLIENT_ID));
        context.setHttpHeaders(httpHeaders);
        context.setOtpNo(httpHeaders.getFirst(X_OTP_NO));
        context.setUserAgent(httpHeaders.getFirst(X_USER_AGENT));
        context.setPlatform(httpHeaders.getFirst(X_PLATFORM));
        context.setChannelId(httpHeaders.getFirst(X_CHANNEL_ID));
        context.setApiKey(httpHeaders.getFirst(X_API_KEY));
        context.setClientSecret(httpHeaders.getFirst(X_CLIENT_SECRET));
        context.setSecretKey(httpHeaders.getFirst(X_SECRET_KEY));
        context.setSignature(httpHeaders.getFirst(X_SIGNATURE));
        context.setTraceId(httpHeaders.getFirst(X_TRACE_ID));
        context.setSpanId(httpHeaders.getFirst(X_SPAN_ID));

        return true;
    }

    public static HttpHeaders applyHttpHeaders(HttpServletRequest request) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Enumeration<String> requestHeaders = request.getHeaderNames();

        if (requestHeaders != null) {
            while (requestHeaders.hasMoreElements()) {
                String header = requestHeaders.nextElement();
                String value = request.getHeader(header);
                if (ALLOW_HEADERS.contains(header)) {
                    log.debug("Adding header {} with value {}", header, value);
                    httpHeaders.add(header, value);
                } else {
                    log.warn("Header {} with value {} is ignored", header, value);
                }
            }
        }

        if (!httpHeaders.containsKey(X_ACCEPT_LANGUAGE) || StringUtils
                .isEmpty(httpHeaders.getFirst(
                        X_ACCEPT_LANGUAGE))) {
            httpHeaders.set(X_ACCEPT_LANGUAGE, DEFAULT_LANGUAGE);
        }

        return httpHeaders;
    }
}
