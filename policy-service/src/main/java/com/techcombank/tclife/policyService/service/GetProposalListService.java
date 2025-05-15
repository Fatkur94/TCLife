package com.techcombank.tclife.policyService.service;

import com.techcombank.tclife.common.base.BasePaginationRequest;
import com.techcombank.tclife.common.base.BasePaginationResponse;
import com.techcombank.tclife.common.exception.TechnicalException;
import com.techcombank.tclife.common.service.BaseService;
import com.techcombank.tclife.common.service.ResponseWrapper;
import com.techcombank.tclife.policyService.constant.PolicyErrorType;
import com.techcombank.tclife.policyService.model.response.ProposalResponse;
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
public class GetProposalListService implements BaseService<BasePaginationRequest, BasePaginationResponse<ProposalResponse>> {
    @Override
    public ResponseWrapper<BasePaginationResponse<ProposalResponse>> proceed(BasePaginationRequest input) {
        Pageable pageable = input.toPageable();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dob = null;
        try {
            dob = dateFormat.parse("1991-01-01");
        } catch (ParseException e) {
            log.error("Cannot Parse dob Date");
            throw new TechnicalException(PolicyErrorType.PARSE_DATE_ERROR);
        }

        Date creationDate = null;
        try {
            creationDate = dateFormat.parse("1991-01-01");
        } catch (ParseException e) {
            log.error("Cannot Parse creation Date");
            throw new TechnicalException(PolicyErrorType.PARSE_DATE_ERROR);
        }

        ProposalResponse proposal = ProposalResponse.builder()
                .fullName("Jane Smith")
                .leadId("LID789012")
                .proposalId("PROP456789")
                .dob(dob)
                .creationDate(creationDate)
                .proposalStatus("Pending")
                .build();

        List<ProposalResponse> policyResponses = Arrays.asList(proposal);
        Page<ProposalResponse> page = new PageImpl<>(
                policyResponses,
                pageable,
                policyResponses.size()
        );

        BasePaginationResponse<ProposalResponse> response = new BasePaginationResponse<>(
                page.getContent(),
                page.getNumber() + 1,
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
        return successResponse(response);
    }
}
