package com.techcombank.tclife.leadService.service;

import com.techcombank.tclife.common.model.dto.GetLeadDetailResponse;
import com.techcombank.tclife.common.service.BaseService;
import com.techcombank.tclife.common.wrapper.ResponseWrapper;
import com.techcombank.tclife.leadService.client.LeadDataClient;
import com.techcombank.tclife.leadService.model.request.GetLeadDetailRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GetLeadDetailService implements BaseService<GetLeadDetailRequest, GetLeadDetailResponse> {

    private final LeadDataClient leadDataClient;
    public GetLeadDetailService(LeadDataClient leadDataClient) {
        this.leadDataClient = leadDataClient;
    }

    @Override
    public ResponseWrapper<GetLeadDetailResponse> proceed(GetLeadDetailRequest input) {
        var leadDetail = leadDataClient.getLeadById(input.getLeadId());
        return successResponse(leadDetail.getData());
    }
}
