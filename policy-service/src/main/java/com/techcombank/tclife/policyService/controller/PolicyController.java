package com.techcombank.tclife.policyService.controller;

import com.techcombank.tclife.common.base.BasePaginationRequest;
import com.techcombank.tclife.common.base.BasePaginationResponse;
import com.techcombank.tclife.common.security.annotation.ApiMiddleware;
import com.techcombank.tclife.common.security.model.ApiAccessScope;
import com.techcombank.tclife.common.security.model.ApiAccessScopes;
import com.techcombank.tclife.common.wrapper.ResponseWrapper;
import com.techcombank.tclife.policyService.model.request.GetPolicyDetailRequest;
import com.techcombank.tclife.policyService.model.response.GetPolicyDetailResponse;
import com.techcombank.tclife.policyService.model.response.PolicyResponse;
import com.techcombank.tclife.policyService.service.GetPolicyDetailService;
import com.techcombank.tclife.policyService.service.GetPolicyListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/policy-service/api/v1")
@Tag(name = "Policy Management", description = "APIs for managing policy")
public class PolicyController {

    private GetPolicyListService getPolicyListService;
    private GetPolicyDetailService getPolicyDetailService;

    public PolicyController(GetPolicyListService getPolicyListService,
                            GetPolicyDetailService getPolicyDetailService) {
        this.getPolicyListService = getPolicyListService;
        this.getPolicyDetailService = getPolicyDetailService;
    }

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }

    @ApiMiddleware(scope = {ApiAccessScope.SALES})
    @Operation(summary = "")
    @GetMapping("/policies")
    public ResponseWrapper<BasePaginationResponse<PolicyResponse>> getPolicyList(BasePaginationRequest request) {
        return getPolicyListService.proceed(request);
    }

    @ApiMiddleware(scope = {ApiAccessScope.INTERNAL, ApiAccessScope.SALES})
    @GetMapping(value="/policies/{policyNo}")
    public ResponseWrapper<GetPolicyDetailResponse> getPolicyDetail(@PathVariable("policyNo") String policyNo) {
        return getPolicyDetailService.proceed(GetPolicyDetailRequest.builder().policyNo(policyNo).build());
    }
}
