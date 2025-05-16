package com.techcombank.tclife.leadService.service;

import com.techcombank.tclife.common.base.BasePaginationRequest;
import com.techcombank.tclife.common.base.BasePaginationResponse;
import com.techcombank.tclife.common.service.BaseService;
import com.techcombank.tclife.common.wrapper.ResponseWrapper;
import com.techcombank.tclife.leadService.model.response.LeadResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class GetLeadListService implements BaseService<BasePaginationRequest, BasePaginationResponse<LeadResponse>> {
    @Override
    public ResponseWrapper<BasePaginationResponse<LeadResponse>> proceed(BasePaginationRequest input) {
        Pageable pageable = input.toPageable();

        LeadResponse lead = LeadResponse.builder()
                .fullName("Jane Smith")
                .dob(LocalDate.of(1985, 8, 22))
                .leadId("LEAD2025001")
                .creationDate(LocalDateTime.of(2025, 5, 15, 9, 0))
                .leadAging(10)
                .build();

        List<LeadResponse> leadResponses = Arrays.asList(lead);
        Page<LeadResponse> page = new PageImpl<>(
                leadResponses,
                pageable,
                leadResponses.size()
        );

        BasePaginationResponse<LeadResponse> response = new BasePaginationResponse<>(
                page.getContent(),
                page.getNumber() + 1,
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
        return successResponse(response);
    }
}
