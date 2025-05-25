package com.techcombank.tclife.dataService.controller;

import com.techcombank.tclife.common.wrapper.ClientResponseWrapper;
import com.techcombank.tclife.dataService.model.dto.Request.FeatureConfigRequest;
import com.techcombank.tclife.dataService.model.entity.FeatureConfig;
import com.techcombank.tclife.dataService.model.response.FeatureConfigResponse;
import com.techcombank.tclife.dataService.service.FeatureConfigDataService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/feature-config")
@AllArgsConstructor
public class FeatureConfigController {

    private final FeatureConfigDataService featureConfigDataService;

    @GetMapping("/get-feature-config-by-feature-name-scope")
    public ResponseEntity<ClientResponseWrapper<FeatureConfigResponse>> getFeatureConfigByFeatureNameScope(
            @RequestBody FeatureConfigRequest request
    ) {
        try {
            FeatureConfig featureConfig = featureConfigDataService.getFeatureConfigByFeatureNameScope(
                    request.getFeatureName(), request.getScope());
            if (featureConfig == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ClientResponseWrapper<>(false,
                                "Feature config not found.", null));
            }

            FeatureConfigResponse featureConfigResponse = FeatureConfigResponse.builder()
                    .featureName(featureConfig.getFeatureName())
                    .description(featureConfig.getDescription())
                    .scope(featureConfig.getScope())
                    .isEnabled(featureConfig.isEnabled())
                    .config(featureConfig.getConfig())
                    .build();

            return ResponseEntity.ok(new ClientResponseWrapper<>(true,
                    "Feature config fetched successfully.", featureConfigResponse));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ClientResponseWrapper<>(false,
                            "Failed to fetch feature config: " + ex.getMessage(), null));
        }
    }
}

