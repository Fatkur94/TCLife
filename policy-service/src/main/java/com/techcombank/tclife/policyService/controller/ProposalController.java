package com.techcombank.tclife.policyService.controller;

import com.techcombank.tclife.common.base.BasePaginationRequest;
import com.techcombank.tclife.common.base.BasePaginationResponse;
import com.techcombank.tclife.common.service.ResponseWrapper;
import com.techcombank.tclife.policyService.model.response.ProposalResponse;
import com.techcombank.tclife.policyService.service.GetProposalListService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/policy-service/api/v1")
public class ProposalController {
    public GetProposalListService getProposalListService;

    public ProposalController(GetProposalListService getProposalListService) {
        this.getProposalListService = getProposalListService;
    }

    @Operation(summary = "")
    @GetMapping("/proposals")
    public ResponseWrapper<BasePaginationResponse<ProposalResponse>> getProposalList(BasePaginationRequest request) {
        return getProposalListService.proceed(request);
    }
}
