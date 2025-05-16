package com.techcombank.tclife.claimService.controller;

import com.techcombank.tclife.claimService.model.response.ClaimResponse;
import com.techcombank.tclife.claimService.service.GetClaimListService;
import com.techcombank.tclife.common.base.BasePaginationRequest;
import com.techcombank.tclife.common.base.BasePaginationResponse;
import com.techcombank.tclife.common.wrapper.ResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/claim-service/api/v1")
public class ClaimController {

    public GetClaimListService getClaimListService;

    public ClaimController(GetClaimListService getClaimListService) {
        this.getClaimListService = getClaimListService;
    }

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }

    @GetMapping("/claims")
    public ResponseWrapper<BasePaginationResponse<ClaimResponse>> getClaimList(BasePaginationRequest request) {
        return getClaimListService.proceed(request);
    }
}
