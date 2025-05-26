package com.techcombank.tclife.common.context;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PortalContextConfig implements WebMvcConfigurer {

    private final PortalContextInterceptor portalContextInterceptor;

    public PortalContextConfig(PortalContextInterceptor portalContextInterceptor) {
        this.portalContextInterceptor = portalContextInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(portalContextInterceptor).addPathPatterns("/**");
    }
}


