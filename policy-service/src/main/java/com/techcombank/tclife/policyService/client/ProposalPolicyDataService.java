package com.techcombank.tclife.policyService.client;

import com.techcombank.tclife.common.model.dto.data.MasterTable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@FeignClient(name = "data-service", url = "${integration.portal.data-service.base-url}")
public interface ProposalPolicyDataService {
    @GetMapping("/en_US/retrieveStatusPayload")
    List<MasterTable> getENStatusPayload();
}
