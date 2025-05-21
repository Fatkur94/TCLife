package com.techcombank.tclife.dataService.controller;

import com.techcombank.tclife.common.model.EmptyResponse;
import com.techcombank.tclife.common.security.annotation.ApiMiddleware;
import com.techcombank.tclife.common.security.model.ApiAccessScope;
import com.techcombank.tclife.common.wrapper.ResponseWrapper;
import com.techcombank.tclife.dataService.model.request.PostLeadRequest;
import com.techcombank.tclife.dataService.service.PostLeadService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data-service/api/v1/leads")
public class LeadController {
    private PostLeadService postLeadService;

    public LeadController(PostLeadService postLeadService) {
        this.postLeadService = postLeadService;
    }

    @ApiMiddleware(scope = {ApiAccessScope.INTERNAL})
    @PostMapping()
    public ResponseWrapper<EmptyResponse> postLead(@Valid @RequestBody PostLeadRequest request) {
        return postLeadService.proceed(request);
    }

}
