package com.techcombank.tclife.common.client;

import com.techcombank.tclife.common.context.PortalContextInterceptor;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Collections;

@Component
public class FeignPortalContextInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) return;

        HttpServletRequest request = attributes.getRequest();

        Collections.list(request.getHeaderNames()).forEach(header -> {
            String value = request.getHeader(header);
            if (PortalContextInterceptor.ALLOW_HEADERS.contains(header.toLowerCase())) {
                template.header(header, value);
            }
        });
    }
}

