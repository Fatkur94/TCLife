package com.techcombank.tclife.policyService.service;

import com.techcombank.tclife.common.wrapper.ResponseWrapper;
import com.techcombank.tclife.policyService.model.response.PolicyProposalStatusResponse;
import java.io.IOException;
import java.util.List;

public interface CommonSharedService {
    public ResponseWrapper<List<PolicyProposalStatusResponse>> getCommonStatusForProposalAndPolicy() throws IOException ;
    public List<PolicyProposalStatusResponse> getStatusPayload(String tokenApi) throws IOException;
}
