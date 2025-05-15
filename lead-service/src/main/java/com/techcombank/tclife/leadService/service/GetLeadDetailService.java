package com.techcombank.tclife.leadService.service;

import com.techcombank.tclife.common.service.BaseService;
import com.techcombank.tclife.common.service.ResponseWrapper;
import com.techcombank.tclife.leadService.model.request.GetLeadDetailRequest;
import com.techcombank.tclife.leadService.model.response.GetLeadDetailResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class GetLeadDetailService implements BaseService<GetLeadDetailRequest, GetLeadDetailResponse> {
    @Override
    public ResponseWrapper<GetLeadDetailResponse> proceed(GetLeadDetailRequest input) {
        GetLeadDetailResponse leadResponse = GetLeadDetailResponse.builder()
                .fullName("Michael Chen")
                .dob(LocalDate.of(1990, 3, 12))
                .gender("Male")
                .bankSegment("Retail")
                .insuranceSegment("Life")
                .occupation("Lawyer")
                .mainInsured("Michael Chen")
                .build();
        return successResponse(leadResponse);
    }
}
