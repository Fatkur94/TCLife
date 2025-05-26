package com.techcombank.tclife.policyService.client;

import com.techcombank.tclife.common.model.dto.policy.ProposalPolicyPayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "integration-service", url = "${integration.portal.data-service.base-url}")
public interface ProposalPolicyIntegrationClient {
    @GetMapping("/retrievePayloadToTransform")
    ProposalPolicyPayload getPayloadToTransform();
}


