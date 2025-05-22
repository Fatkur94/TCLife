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
import com.techcombank.tclife.policyService.model.response.ProposalResponse;
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
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GetProposalListService implements BaseService<BasePaginationRequest, BasePaginationResponse<ProposalResponse>> {

    private final DataAPI dataAPI;

    @Override
    public ResponseWrapper<BasePaginationResponse<ProposalResponse>> proceed(BasePaginationRequest input) {
        Pageable pageable = input.toPageable();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
        /*Date dob = null;
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
        }*/

        String resource = "C:\\Users\\dsutomo\\apps\\workspace\\TCLife\\policy-service\\src\\main\\resources\\mockJson\\payload.json";
        ObjectMapper objectMapper = new ObjectMapper();
        ProposalPolicyPayload proposal = null;
        try {
            proposal = objectMapper.readValue(new File(resource), ProposalPolicyPayload.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*ProposalResponse proposal = ProposalResponse.builder()
                .fullName("Jane Smith")
                .leadId("LID789012")
                .proposalId("PROP456789")
                .dob(dob)
                .creationDate(creationDate)
                .proposalStatus("Pending")
                .build();
*/
        List<ProposalResponse> proposalResponses = new ArrayList<>();
        List<MasterTable> statusCode = dataAPI.getENStatusPayload();


        for(ProposalPolicyData x : proposal.getData()){
            ProposalResponse proposalLoop = new ProposalResponse();
            proposalLoop.setProposalId(x.getProposalNo());
            System.out.println("proposal id :  "+x.getProposalNo());
            //confirm logic on calculate this aging
            proposalLoop.setProposalAging(3);
            try {
                proposalLoop.setDob(dateFormat.parse(x.getPolicyHolderBirthday()));
                proposalLoop.setCreationDate(dateFormat.parse(x.getSubmissionDate()));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            proposalLoop.setFullName(x.getPolicyInsured());
            //later will need to update
            proposalLoop.setLeadId("test1");
            MasterTable policyProposalStatusResponse = statusCode.stream().filter(status -> x.getPolicyStatus().equals(status.getCode())).findAny().orElse(null);
            proposalLoop.setProposalStatus(policyProposalStatusResponse.getDesc());
            proposalResponses.add(proposalLoop);

        }
        Page<ProposalResponse> page = new PageImpl<>(
                proposalResponses,
                pageable,
                proposalResponses.size()
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
