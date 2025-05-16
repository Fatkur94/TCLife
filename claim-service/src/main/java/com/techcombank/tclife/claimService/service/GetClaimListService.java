package com.techcombank.tclife.claimService.service;

import com.techcombank.tclife.claimService.model.response.ClaimResponse;
import com.techcombank.tclife.common.base.BasePaginationRequest;
import com.techcombank.tclife.common.base.BasePaginationResponse;
import com.techcombank.tclife.common.exception.TechnicalException;
import com.techcombank.tclife.common.service.BaseService;
import com.techcombank.tclife.common.wrapper.ResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class GetClaimListService implements BaseService<BasePaginationRequest, BasePaginationResponse<ClaimResponse>> {

    @Override
    public ResponseWrapper<BasePaginationResponse<ClaimResponse>> proceed(BasePaginationRequest input) {
        Pageable pageable = input.toPageable();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date notifDate = null;
        try {
            notifDate = dateFormat.parse("1991-01-01");
        } catch (ParseException e) {
            throw new TechnicalException(HttpStatus.CONFLICT, "4090204", "Cannot Parse notification Date", "FAILED_TO_PARSE_NOTIFICATION_DATE");
        }

        Date approvalDate = null;
        try {
            approvalDate = dateFormat.parse("1991-01-01");
        } catch (ParseException e) {
            log.error("Cannot Parse approval Date");
            throw new TechnicalException("5000203", "Cannot Parse approval Date");
        }

        ClaimResponse claims = ClaimResponse.builder()
                .claimNo("CLM123456")
                .claimType("Health")
                .insured("John Doe")
                .policyNo("POL987654")
                .notificationDate(notifDate)
                .approvalDate(approvalDate)
                .claimStatus("Approved")
                .build();

        List<ClaimResponse> claimResponses = Arrays.asList(claims);
        Page<ClaimResponse> page = new PageImpl<>(
                claimResponses,
                pageable,
                claimResponses.size()
        );

        BasePaginationResponse<ClaimResponse> response = new BasePaginationResponse<>(
                page.getContent(),
                page.getNumber() + 1,
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
        return successResponse(response);
    }
}
