package com.techcombank.tclife.leadService.client;


import com.techcombank.tclife.common.model.EmptyResponse;
import com.techcombank.tclife.common.wrapper.ClientResponseWrapper;
import com.techcombank.tclife.leadService.model.request.CRMLeadsRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class IntegrationServiceClient {

    @Value("${integration.portal.data-service.get-config.url}")
    private String getConfigUrl;

    @Value("${integration.portal.data-service.post-lead.url}")
    private String postLeadUrl;

    private WebClient portalWebClient;

    public IntegrationServiceClient(
                             @Qualifier(value = "portalWebClient") WebClient portalWebClient) {
        this.portalWebClient = portalWebClient;
    }

    public EmptyResponse postLeads(CRMLeadsRequest request) {
            return portalWebClient.post()
                    .uri(postLeadUrl)
                    .bodyValue(request)
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<ClientResponseWrapper<EmptyResponse>>() {})
                    .map(ClientResponseWrapper::getData)
                    .block();
    }
}
