package com.techcombank.tclife.policyService.service;

import com.techcombank.tclife.common.service.BaseService;
import com.techcombank.tclife.common.service.ResponseWrapper;
import com.techcombank.tclife.policyService.model.request.GetPolicyDetailRequest;
import com.techcombank.tclife.policyService.model.response.GetPolicyDetailResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class GetPolicyDetailService implements BaseService<GetPolicyDetailRequest, GetPolicyDetailResponse> {
    @Override
    public ResponseWrapper<GetPolicyDetailResponse> proceed(GetPolicyDetailRequest input) {
        GetPolicyDetailResponse policyDetail = GetPolicyDetailResponse.builder()
                .policyNo("POL987654321")
                .servicingBranch("Surabaya Main")
                .issueDate(LocalDate.of(2025, 4, 1))
                .policyStatus("Active")
                .commenceDate(LocalDate.of(2025, 5, 1))
                .coverEndDate(LocalDate.of(2026, 4, 30))
                .productName("SecureLife Pro")
                .productCode("SLP002")
                .lifeAssured("Sarah Johnson")
                .sumAssured(1500000.00)
                .unit(15)
                .level(3)
                .premiumStatus("Paid")
                .standardPremium(18000.75)
                .build();
        return successResponse(policyDetail);
    }
}
