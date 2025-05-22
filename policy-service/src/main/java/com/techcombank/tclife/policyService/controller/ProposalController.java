package com.techcombank.tclife.policyService.controller;

import com.techcombank.tclife.common.base.BasePaginationRequest;
import com.techcombank.tclife.common.base.BasePaginationResponse;
import com.techcombank.tclife.common.security.annotation.ApiMiddleware;
import com.techcombank.tclife.common.security.model.ApiAccessScope;
import com.techcombank.tclife.common.wrapper.ResponseWrapper;
import com.techcombank.tclife.policyService.model.response.ProposalResponse;
import com.techcombank.tclife.policyService.service.GetProposalListService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/policy-service/api/v1")
@RequiredArgsConstructor
@Validated
public class ProposalController {
    public final GetProposalListService getProposalListService;

    @ApiMiddleware(scope = {ApiAccessScope.SALES})
    @Operation(summary = "")
    @GetMapping("/proposals")
    public ResponseWrapper<BasePaginationResponse<ProposalResponse>> getProposalList(BasePaginationRequest request) {
        return getProposalListService.proceed(request);
    }
}
