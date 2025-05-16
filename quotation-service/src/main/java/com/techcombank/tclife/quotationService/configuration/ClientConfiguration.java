package com.techcombank.tclife.quotationService.configuration;

import com.techcombank.tclife.common.handler.RestTemplateErrorHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Configuration
@Slf4j
public class ClientConfiguration {

    @Value("${integration.portal.connect-timeout}")
    private Integer portalConnectionTimeout;

    @Value("${integration.portal.read-timeout}")
    private Integer portalReadTimeout;

    @Value("${integration.portal.connectionRequestTimeout:2000}")
    private Integer connectionRequestTimeout;

    @Value("${integration.portal.secret-key.value}")
    private String secretKeyValue;

    @Bean(name = "portalRestTemplate")
    public RestTemplate portalRestTemplate() {
        RestTemplate restTemplate = new RestTemplate(customHttpRequestFactory());
        restTemplate.setInterceptors(List.of(new InternalInterceptor()));
        restTemplate.setErrorHandler(new RestTemplateErrorHandler());
        return restTemplate;
    }

    @Bean
    public HttpComponentsClientHttpRequestFactory customHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setConnectTimeout(portalConnectionTimeout);
        factory.setReadTimeout(portalReadTimeout);
        factory.setConnectionRequestTimeout(connectionRequestTimeout);
        return factory;
    }

    class InternalInterceptor implements ClientHttpRequestInterceptor {
        @Override
        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
            request.getHeaders().set("X-Secret-Key", secretKeyValue);
            return execution.execute(request, body);
        }
    }
}
