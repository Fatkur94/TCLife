package com.techcombank.tclife.dataService.controller;

import com.techcombank.tclife.dataService.model.dto.Request.FeatureConfigRequest;
import com.techcombank.tclife.dataService.model.entity.FeatureConfig;
import com.techcombank.tclife.dataService.service.FeatureConfigDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/feature-config")
@AllArgsConstructor
public class FeatureConfigController {

    private final FeatureConfigDataService featureConfigDataService;

    @GetMapping("/get-feature-config-by-feature-name-scope")
    public FeatureConfig getFeatureConfigByFeatureNameScope(FeatureConfigRequest request) {
        return featureConfigDataService.getFeatureConfigByFeatureNameScope(request.getFeatureName(), request.getScope());
    }
}
