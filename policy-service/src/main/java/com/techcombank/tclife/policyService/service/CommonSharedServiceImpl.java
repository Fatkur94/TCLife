package com.techcombank.tclife.policyService.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techcombank.tclife.common.wrapper.ResponseWrapper;
import com.techcombank.tclife.policyService.model.entity.BusinessCodeTableValueList;
import com.techcombank.tclife.policyService.model.entity.DataTable;
import com.techcombank.tclife.policyService.model.response.PolicyProposalStatusResponse;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommonSharedServiceImpl implements CommonSharedService{

    public ResponseWrapper<List<PolicyProposalStatusResponse>> getCommonStatusForProposalAndPolicy() throws IOException {
        String tokenAPI = "test";
        List returnStatusList = this.getStatusPayload(tokenAPI);
        return new ResponseWrapper<>(true, returnStatusList);
    }

    public List<PolicyProposalStatusResponse> getStatusPayload(String tokenApi) throws IOException {
        String code = "TProposalStatus";
        //later change to url
        String resource = "C:\\Users\\dsutomo\\apps\\workspace\\TCLife\\policy-service\\src\\main\\resources\\mockJson\\policyStatusMock.json";
        //call external api later

        //later change to response from external
        ObjectMapper objectMapper = new ObjectMapper();
        DataTable commonStatus = objectMapper.readValue(new File(resource), DataTable.class);
        List<BusinessCodeTableValueList> valueCode = commonStatus.getBusinessCodeTableValueListList();
        List<PolicyProposalStatusResponse> returnStatusList = new ArrayList<>();
        for(BusinessCodeTableValueList descValue : valueCode){
            PolicyProposalStatusResponse policyProposalStatusResponse = new PolicyProposalStatusResponse();
            policyProposalStatusResponse.setCode(descValue.getCode());
            policyProposalStatusResponse.setDesc(descValue.getDescription());
            returnStatusList.add(policyProposalStatusResponse);
        }
        return returnStatusList;
    }

   /* public static void main(String[] args) throws IOException {
        System.out.println("test");
        String code = "TProposalStatus";
        //later change to url
        String resource = "C:\\Users\\dsutomo\\apps\\workspace\\TCLife\\policy-service\\src\\main\\resources\\mockJson\\policyStatusMock.json";
        //call external api later

        //later change to response from external
        ObjectMapper objectMapper = new ObjectMapper();
        DataTable commonStatus = objectMapper.readValue(new File(resource), DataTable.class);
        List<BusinessCodeTableValueList> valueCode = commonStatus.getBusinessCodeTableValueListList();
        List<PolicyProposalStatusResponse> returnStatusList = new ArrayList<>();
        for(BusinessCodeTableValueList descValue : valueCode){
            PolicyProposalStatusResponse policyProposalStatusResponse = new PolicyProposalStatusResponse();
            policyProposalStatusResponse.setCode(descValue.getCode());
            policyProposalStatusResponse.setDesc(descValue.getDescription());
            returnStatusList.add(policyProposalStatusResponse);
        }

    }*/
}
