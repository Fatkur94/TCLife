package com.techcombank.tclife.leadService.controller;

import com.techcombank.tclife.common.base.BasePaginationRequest;
import com.techcombank.tclife.common.base.BasePaginationResponse;
import com.techcombank.tclife.common.wrapper.ResponseWrapper;
import com.techcombank.tclife.leadService.model.request.GetLeadDetailRequest;
import com.techcombank.tclife.leadService.model.response.GetLeadDetailResponse;
import com.techcombank.tclife.leadService.model.response.LeadResponse;
import com.techcombank.tclife.leadService.service.GetLeadDetailService;
import com.techcombank.tclife.leadService.service.GetLeadListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lead-service/api/v1")
public class LeadController {

    public GetLeadListService getLeadListService;
    public GetLeadDetailService getLeadDetailService;

    public LeadController(GetLeadListService getLeadListService,
                          GetLeadDetailService getLeadDetailService) {
        this.getLeadListService = getLeadListService;
        this.getLeadDetailService = getLeadDetailService;

    }

    @GetMapping("/leads")
    public ResponseWrapper<BasePaginationResponse<LeadResponse>> getLeadList(BasePaginationRequest request) {
        return getLeadListService.proceed(request);
    }

    @GetMapping(value="/leads/{leadId}")
    public ResponseWrapper<GetLeadDetailResponse> getLeadDetail(@PathVariable("leadId") String leadId) {
        return getLeadDetailService.proceed(GetLeadDetailRequest.builder().leadId(leadId).build());
    }
}
