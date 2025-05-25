package com.techcombank.tclife.quotationService.client;

import com.techcombank.tclife.dataService.model.dto.Request.FeatureConfigRequest;
import com.techcombank.tclife.dataService.model.entity.FeatureConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "feature-config-data", url = "${integration.portal.data-service.base-url}", path = "/api/v1/feature-config")
public interface FeatureConfigDataClient {
    @GetMapping("/get-feature-config-by-feature-name-scope")
    FeatureConfig getFeatureConfigByFeatureNameScope(@RequestBody FeatureConfigRequest request);
}
