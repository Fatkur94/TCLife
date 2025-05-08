package com.techcombank.tclife.policyService.controller;

import com.techcombank.tclife.common.base.BasePaginationRequest;
import com.techcombank.tclife.common.base.BasePaginationResponse;
import com.techcombank.tclife.common.service.ResponseWrapper;
import com.techcombank.tclife.policyService.model.response.PolicyResponse;
import com.techcombank.tclife.policyService.service.GetPolicyListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/policy-service/api/v1")
@Tag(name = "Policy Management", description = "APIs for managing policy")
public class PolicyController {

    public GetPolicyListService getPolicyListService;

    public PolicyController(GetPolicyListService getPolicyListService) {
        this.getPolicyListService = getPolicyListService;
    }

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }

    @Operation(summary = "")
    @GetMapping("/policies")
    public ResponseWrapper<BasePaginationResponse<PolicyResponse>> getPolicyList(BasePaginationRequest request) {
        return getPolicyListService.proceed(request);
    }
}
