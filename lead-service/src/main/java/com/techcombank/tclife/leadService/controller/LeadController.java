package com.techcombank.tclife.leadService.controller;

import com.techcombank.tclife.common.base.BaseListResponse;
import com.techcombank.tclife.common.base.BasePaginationRequest;
import com.techcombank.tclife.common.model.EmptyResponse;
import com.techcombank.tclife.common.security.annotation.ApiMiddleware;
import com.techcombank.tclife.common.security.model.ApiAccessScope;
import com.techcombank.tclife.common.wrapper.ResponseWrapper;
import com.techcombank.tclife.leadService.model.request.CRMLeadsRequest;
import com.techcombank.tclife.leadService.model.request.GetLeadDetailRequest;
import com.techcombank.tclife.leadService.model.response.GetLeadDetailResponse;
import com.techcombank.tclife.leadService.model.response.GetLeadsResponse;
import com.techcombank.tclife.leadService.service.CRMLeadsConsumerService;
import com.techcombank.tclife.leadService.service.GetLeadDetailService;
import com.techcombank.tclife.leadService.service.GetLeadListService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lead-service/api/v1")
public class LeadController {

    private GetLeadListService getLeadListService;
    private GetLeadDetailService getLeadDetailService;
    private CRMLeadsConsumerService crmLeadsConsumerService;

    public LeadController(GetLeadListService getLeadListService,
                          GetLeadDetailService getLeadDetailService,
                          CRMLeadsConsumerService crmLeadsConsumerService) {
        this.getLeadListService = getLeadListService;
        this.getLeadDetailService = getLeadDetailService;
        this.crmLeadsConsumerService = crmLeadsConsumerService;

    }

    @ApiMiddleware(scope = {ApiAccessScope.SALES})
    @GetMapping("/leads")
    public ResponseWrapper<BaseListResponse<GetLeadsResponse>> getLeadList(BasePaginationRequest request) {
        return getLeadListService.proceed(request);
    }

    @GetMapping(value="/leads/{leadId}")
    public ResponseWrapper<GetLeadDetailResponse> getLeadDetail(@PathVariable("leadId") String leadId) {
        return getLeadDetailService.proceed(GetLeadDetailRequest.builder().leadId(leadId).build());
    }

    @ApiMiddleware(scope = {ApiAccessScope.SALES})
    @PostMapping("/leads")
    public EmptyResponse postLead(@Valid @RequestBody CRMLeadsRequest request) {
        return crmLeadsConsumerService.proceed(request);
    }
}
