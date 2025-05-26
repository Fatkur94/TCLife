package com.techcombank.tclife.dataService.controller;

import com.techcombank.tclife.common.base.BaseListResponse;
import com.techcombank.tclife.common.model.EmptyRequest;
import com.techcombank.tclife.common.model.EmptyResponse;
import com.techcombank.tclife.common.model.dto.GetLeadDetailResponse;
import com.techcombank.tclife.common.security.annotation.ApiMiddleware;
import com.techcombank.tclife.common.security.model.ApiAccessScope;
import com.techcombank.tclife.common.wrapper.ResponseWrapper;
import com.techcombank.tclife.dataService.model.request.GetLeadDetailRequest;
import com.techcombank.tclife.dataService.model.request.PostLeadRequest;
import com.techcombank.tclife.dataService.model.response.GetLeadsResponse;
import com.techcombank.tclife.dataService.service.GetLeadDetailService;
import com.techcombank.tclife.dataService.service.GetLeadsService;
import com.techcombank.tclife.dataService.service.PostLeadService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data-service/api/v1/leads")
public class LeadController {
    private PostLeadService postLeadService;
    private GetLeadDetailService getLeadDetailService;
    private GetLeadsService getLeadsService;

    public LeadController(PostLeadService postLeadService,
                          GetLeadDetailService getLeadDetailService,
                          GetLeadsService getLeadsService) {
        this.postLeadService = postLeadService;
        this.getLeadDetailService = getLeadDetailService;
        this.getLeadsService = getLeadsService;
    }

    @ApiMiddleware(scope = {ApiAccessScope.INTERNAL})
    @PostMapping()
    public ResponseWrapper<EmptyResponse> postLead(@Valid @RequestBody PostLeadRequest request) {
        return postLeadService.proceed(request);
    }

    @GetMapping
    public ResponseWrapper<BaseListResponse<GetLeadsResponse>> getLeads() {
        return getLeadsService.proceed(new EmptyRequest());
    }

    @GetMapping("/{id}")
    public ResponseWrapper<GetLeadDetailResponse> getLeadById(@PathVariable("id") String id) {
        var getLeadDetailReqeust = GetLeadDetailRequest.builder().id(id).build();
        return getLeadDetailService.proceed(getLeadDetailReqeust);
    }
}
