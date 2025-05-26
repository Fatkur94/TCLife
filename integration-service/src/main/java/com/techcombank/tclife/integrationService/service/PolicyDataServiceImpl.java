package com.techcombank.tclife.integrationService.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techcombank.tclife.common.model.dto.policy.ProposalPolicyPayload;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class PolicyDataServiceImpl implements PolicyDataService{
    @Override
    public ProposalPolicyPayload retrievePayload() {
        //Retrieve access token

        //Prepare payload to call insureMo API
        String resource = "C:\\Users\\dsutomo\\apps\\workspace\\TCLife\\policy-service\\src\\main\\resources\\mockJson\\payload.json";

        //Read respond and transform
        ObjectMapper objectMapper = new ObjectMapper();
        ProposalPolicyPayload policy = null;
        try {
            policy = objectMapper.readValue(new File(resource), ProposalPolicyPayload.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return policy;
    }
}
