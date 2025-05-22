package com.techcombank.tclife.quotationService.client;

import com.techcombank.tclife.common.model.EmptyRequest;
import com.techcombank.tclife.common.wrapper.ClientResponseWrapper;
import com.techcombank.tclife.quotationService.model.response.ConfigResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


//@Component
//public class DataServiceClient {
//
//    @Value("${integration.portal.data-service.get-config.url}")
//    private String getConfigUrl;
//
//    private RestTemplate portalRestTemplate;
//
//    public DataServiceClient(@Qualifier(value = "portalRestTemplate") RestTemplate portalRestTemplate) {
//        this.portalRestTemplate = portalRestTemplate;
//    }
//
//    public ConfigResponse getConfig(EmptyRequest request) {
//        ConfigResponse response = portalRestTemplate.exchange(getConfigUrl,
//                HttpMethod.POST,
//                new HttpEntity<>(request),
//                new ParameterizedTypeReference<ClientResponseWrapper<ConfigResponse>>() {}
//            ).getBody().getData();
//        return response;
//    }
//}
