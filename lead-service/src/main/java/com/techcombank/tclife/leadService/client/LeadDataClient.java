package com.techcombank.tclife.leadService.client;

import com.techcombank.tclife.common.model.dto.GetLeadDetailResponse;
import com.techcombank.tclife.common.wrapper.ClientResponseWrapper;
import com.techcombank.tclife.leadService.model.response.GetLeadsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "data-service", url = "${integration.portal.data-service.base-url}")
public interface LeadDataClient {
    @GetMapping("/api/v1/leads")
    ClientResponseWrapper<List<GetLeadsResponse>> getLeads();

    @GetMapping("/api/v1/leads/{id}")
    ClientResponseWrapper<GetLeadDetailResponse> getLeadById(@PathVariable("id") String id);

}
