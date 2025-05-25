package com.techcombank.tclife.policyService.controller;

import com.techcombank.tclife.common.base.BasePaginationRequest;
import com.techcombank.tclife.common.base.BasePaginationResponse;
import com.techcombank.tclife.common.security.annotation.ApiMiddleware;
import com.techcombank.tclife.common.security.model.ApiAccessScope;
import com.techcombank.tclife.common.wrapper.ResponseWrapper;
import com.techcombank.tclife.policyService.model.request.GetPolicyDetailRequest;
import com.techcombank.tclife.policyService.model.response.GetPolicyDetailResponse;
import com.techcombank.tclife.policyService.model.response.PolicyProposalStatusResponse;
import com.techcombank.tclife.policyService.model.response.PolicyResponse;
import com.techcombank.tclife.policyService.service.CommonSharedService;
import com.techcombank.tclife.policyService.service.GetPolicyDetailService;
import com.techcombank.tclife.policyService.service.GetPolicyListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/policy-service/api/v1")
@Tag(name = "Policy Management", description = "APIs for managing policy")
@RequiredArgsConstructor
@Validated
public class PolicyController {

    private final GetPolicyListService getPolicyListService;
    private final GetPolicyDetailService getPolicyDetailService;
    private final CommonSharedService commonSharedService;

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }

    /*@ApiMiddleware(scope = {ApiAccessScope.SALES})*/
    @Operation(summary = "")
    @GetMapping("/policies")
    public ResponseWrapper<BasePaginationResponse<PolicyResponse>> getPolicyList(BasePaginationRequest request) throws IOException {
        return getPolicyListService.proceed(request);
    }

    @ApiMiddleware(scope = {ApiAccessScope.INTERNAL, ApiAccessScope.SALES})
    @GetMapping(value="/policies/{policyNo}")
    public ResponseWrapper<GetPolicyDetailResponse> getPolicyDetail(@PathVariable("policyNo") String policyNo) {
        return getPolicyDetailService.proceed(GetPolicyDetailRequest.builder().policyNo(policyNo).build());
    }

    @GetMapping(value = "/policies/status")
    public ResponseWrapper<List<PolicyProposalStatusResponse>>getPolicyProposalStatus() throws IOException {
        return commonSharedService.getCommonStatusForProposalAndPolicy();
    }

}
