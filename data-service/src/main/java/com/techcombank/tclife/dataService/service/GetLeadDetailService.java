package com.techcombank.tclife.dataService.service;

import com.techcombank.tclife.common.exception.BusinessException;
import com.techcombank.tclife.common.model.dto.GetLeadDetailResponse;
import com.techcombank.tclife.common.service.BaseService;
import com.techcombank.tclife.common.wrapper.ResponseWrapper;
import com.techcombank.tclife.dataService.model.request.GetLeadDetailRequest;
import com.techcombank.tclife.dataService.repository.LeadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GetLeadDetailService implements BaseService<GetLeadDetailRequest, GetLeadDetailResponse> {

    private LeadRepository leadRepository;

    public GetLeadDetailService(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    @Override
    public ResponseWrapper<GetLeadDetailResponse> proceed(GetLeadDetailRequest input) {
        var leadData = leadRepository.findById(input.getId());
        if (!leadData.isPresent()) {
            throw new BusinessException(HttpStatus.NOT_FOUND, "lead not found");
        }
        var leadDetail = GetLeadDetailResponse.builder()
                .fullName(leadData.get().getCustomerName())
//                .dob(leadData.get().getPoDob())
                .bankSegment(leadData.get().getBankStaffName())
                .gender(leadData.get().getPoGender())
                .insuranceSegment(leadData.get().getInsPartner())
                .mainInsured(leadData.get().getBranchCode())
                .occupation(leadData.get().getChannel())
                .build();

        return successResponse(leadDetail);
    }
}
