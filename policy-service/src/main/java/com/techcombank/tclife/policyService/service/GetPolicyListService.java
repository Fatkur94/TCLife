package com.techcombank.tclife.policyService.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techcombank.tclife.common.base.BasePaginationRequest;
import com.techcombank.tclife.common.base.BasePaginationResponse;
import com.techcombank.tclife.common.exception.TechnicalException;
import com.techcombank.tclife.common.service.BaseService;
import com.techcombank.tclife.common.wrapper.ResponseWrapper;
import com.techcombank.tclife.dataService.controller.DataAPI;
import com.techcombank.tclife.dataService.model.entity.MasterTable;
import com.techcombank.tclife.policyService.constant.PolicyErrorType;
import com.techcombank.tclife.policyService.model.entity.ProposalPolicyData;
import com.techcombank.tclife.policyService.model.entity.ProposalPolicyPayload;
import com.techcombank.tclife.policyService.model.response.PolicyResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GetPolicyListService implements BaseService<BasePaginationRequest, BasePaginationResponse<PolicyResponse>> {

    private final CommonSharedService commonSharedService;
    private final DataAPI dataAPI;

    @Override
    public ResponseWrapper<BasePaginationResponse<PolicyResponse>> proceed(BasePaginationRequest input) {
        Pageable pageable = input.toPageable();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");

        String resource = "C:\\Users\\dsutomo\\apps\\workspace\\TCLife\\policy-service\\src\\main\\resources\\mockJson\\payload.json";
        ObjectMapper objectMapper = new ObjectMapper();
        ProposalPolicyPayload policy = null;
        try {
            policy = objectMapper.readValue(new File(resource), ProposalPolicyPayload.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<PolicyResponse> policyResponses = new ArrayList<>();
        List<MasterTable> statusCode = dataAPI.getENStatusPayload();

        for(ProposalPolicyData x : policy.getData()){
            PolicyResponse policyJson = new PolicyResponse();
            policyJson.setFullName(x.getPolicyInsured());
            policyJson.setPolicyNo(x.getPolicyNo());
            Date submissionDate = null;
            try {
                submissionDate = dateFormat.parse(x.getSubmissionDate());
            } catch (ParseException e) {
                log.error("Cannot Parse effective Date");
                throw new TechnicalException(PolicyErrorType.PARSE_DATE_ERROR);
            }
            policyJson.setEffectiveDate(dateFormat2.format(submissionDate));
            MasterTable policyProposalStatusResponse = statusCode.stream().filter(status -> x.getPolicyStatus().equals(status.getCode())).findAny().orElse(null);
            policyJson.setPolicyStatus(policyProposalStatusResponse.getDesc());
            policyResponses.add(policyJson);
        }


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
