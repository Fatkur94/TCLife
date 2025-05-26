package com.techcombank.tclife.integrationService.controller;

import com.techcombank.tclife.common.model.dto.policy.ProposalPolicyPayload;
import com.techcombank.tclife.integrationService.service.PolicyDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/integration-service/api/v1/policy")
public class PolicyController {
    private final PolicyDataService policyDataService;

    @GetMapping("/retrievePayloadToTransform")
    public ProposalPolicyPayload getPayloadToTransform(){
        return policyDataService.retrievePayload();
    }

}
