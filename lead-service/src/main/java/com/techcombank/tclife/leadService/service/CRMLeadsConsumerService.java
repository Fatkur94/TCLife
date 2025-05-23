package com.techcombank.tclife.leadService.service;

import com.techcombank.tclife.common.model.EmptyResponse;
import com.techcombank.tclife.leadService.model.request.CRMLeadsRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CRMLeadsConsumerService {
    public EmptyResponse proceed(CRMLeadsRequest input) {
//        dataServiceClient.postLeads(input);


        // TBD execute callback to CRM
        return new EmptyResponse();
    }

}
