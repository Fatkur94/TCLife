package com.techcombank.tclife.leadService.service;

import com.techcombank.tclife.common.base.BaseListResponse;
import com.techcombank.tclife.common.base.BasePaginationRequest;
import com.techcombank.tclife.common.service.BaseService;
import com.techcombank.tclife.common.wrapper.ResponseWrapper;
import com.techcombank.tclife.leadService.client.LeadDataClient;
import com.techcombank.tclife.leadService.model.response.GetLeadsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GetLeadListService implements BaseService<BasePaginationRequest, BaseListResponse<GetLeadsResponse>> {
    private LeadDataClient leadDataClient;

    public GetLeadListService(LeadDataClient leadDataClient) {
        this.leadDataClient = leadDataClient;
    }

    @Override
    public ResponseWrapper<BaseListResponse<GetLeadsResponse>> proceed(BasePaginationRequest input) {
        var responses = leadDataClient.getLeads();
        BaseListResponse<GetLeadsResponse> responseWrapper = new BaseListResponse<>(responses.getData());
        return successResponse(responseWrapper);
    }
}
