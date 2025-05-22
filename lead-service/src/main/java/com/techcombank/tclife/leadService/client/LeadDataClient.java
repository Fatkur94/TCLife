package com.techcombank.tclife.leadService.client;

import com.techcombank.tclife.common.wrapper.ClientResponseWrapper;
import com.techcombank.tclife.leadService.model.response.GetLeadDetailResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "data-service", url = "http://localhost:8085")
public interface LeadDataClient {
    @GetMapping("/data-service/api/v1/leads/{id}")
    ClientResponseWrapper<GetLeadDetailResponse> getLeadById(@PathVariable("id") String id);
}
