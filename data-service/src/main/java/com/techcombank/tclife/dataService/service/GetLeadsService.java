package com.techcombank.tclife.dataService.service;

import com.techcombank.tclife.common.base.BaseListResponse;
import com.techcombank.tclife.common.model.EmptyRequest;
import com.techcombank.tclife.common.service.BaseService;
import com.techcombank.tclife.common.wrapper.ResponseWrapper;
import com.techcombank.tclife.dataService.model.entity.Lead;
import com.techcombank.tclife.dataService.model.response.GetLeadsResponse;
import com.techcombank.tclife.dataService.repository.LeadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GetLeadsService implements BaseService<EmptyRequest, BaseListResponse<GetLeadsResponse>> {
    private LeadRepository leadRepository;

    public GetLeadsService(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    @Override
    public ResponseWrapper<BaseListResponse<GetLeadsResponse>> proceed(EmptyRequest input) {
        List<Lead> leadData = leadRepository.findAll();

        List<GetLeadsResponse> leadsResponses = leadData.stream()
                .map(lead -> {
                    GetLeadsResponse response = new GetLeadsResponse();
                    response.setLeadId(lead.getId());
                    response.setFullName(lead.getCustomerName());
                    response.setDob(lead.getPoDob());
                    response.setCreationDate(lead.getPoidentityIssueDate());
                    response.setLeadAging(0);
                    return response;
                })
                .collect(Collectors.toList());
        BaseListResponse<GetLeadsResponse> responseWrapper = new BaseListResponse<>(leadsResponses, null); // TODO : adjust this if needed.
        return successResponse(responseWrapper);
    }
}
