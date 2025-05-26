package com.techcombank.tclife.policyService.service;

import com.techcombank.tclife.common.base.BasePaginationRequest;
import com.techcombank.tclife.common.base.BasePaginationResponse;
import com.techcombank.tclife.common.model.dto.data.MasterTable;
import com.techcombank.tclife.common.model.dto.policy.ProposalPolicyData;
import com.techcombank.tclife.common.model.dto.policy.ProposalPolicyPayload;
import com.techcombank.tclife.common.service.BaseService;
import com.techcombank.tclife.common.wrapper.ResponseWrapper;
import com.techcombank.tclife.policyService.client.ProposalPolicyDataService;
import com.techcombank.tclife.policyService.client.ProposalPolicyIntegrationClient;

import com.techcombank.tclife.policyService.model.response.ProposalResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class GetProposalListService implements BaseService<BasePaginationRequest, BasePaginationResponse<ProposalResponse>> {

    private final ProposalPolicyIntegrationClient proposalPolicyIntegrationClient;
    private final ProposalPolicyDataService proposalPolicyDataService;

    @Override
    public ResponseWrapper<BasePaginationResponse<ProposalResponse>> proceed(BasePaginationRequest input) {
        Pageable pageable = input.toPageable();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");

        ProposalPolicyPayload proposal = proposalPolicyIntegrationClient.getPayloadToTransform();
        List<MasterTable> statusCode = proposalPolicyDataService.getENStatusPayload();

        List<ProposalResponse> proposalResponses = new ArrayList<>();
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
