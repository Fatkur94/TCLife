package com.techcombank.tclife.policyService.service;

import com.techcombank.tclife.common.base.BasePaginationRequest;
import com.techcombank.tclife.common.base.BasePaginationResponse;
import com.techcombank.tclife.common.exception.TechnicalException;
import com.techcombank.tclife.common.service.BaseService;
import com.techcombank.tclife.common.service.ResponseWrapper;
import com.techcombank.tclife.policyService.constant.PolicyErrorType;
import com.techcombank.tclife.policyService.model.response.PolicyResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class GetPolicyListService implements BaseService<BasePaginationRequest, BasePaginationResponse<PolicyResponse>> {
    @Override
    public ResponseWrapper<BasePaginationResponse<PolicyResponse>> proceed(BasePaginationRequest input) {
        Pageable pageable = input.toPageable();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date effectiveDate = null;
        try {
            effectiveDate = dateFormat.parse("2025-01-01");
        } catch (ParseException e) {
            log.error("Cannot Parse effective Date");
            throw new TechnicalException(PolicyErrorType.PARSE_DATE_ERROR);
        }

        PolicyResponse policy = PolicyResponse.builder()
                .fullName("John Doe")
                .policyNo("POL123456")
                .productName("Life Insurance")
                .effectiveDate(effectiveDate)
                .policyStatus("Active")
                .build();

        List<PolicyResponse> policyResponses = Arrays.asList(policy);
        Page<PolicyResponse> page = new PageImpl<>(
                policyResponses,
                pageable,
                policyResponses.size()
        );

        BasePaginationResponse<PolicyResponse> response = new BasePaginationResponse<>(
                page.getContent(),
                page.getNumber() + 1,
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );

        return successResponse(response);
    }

}
