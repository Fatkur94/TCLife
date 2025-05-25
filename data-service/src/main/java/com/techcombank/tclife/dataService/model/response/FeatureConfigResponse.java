package com.techcombank.tclife.dataService.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class FeatureConfigResponse {
    private String featureName;
    private String description;
    private String scope;
    private boolean isEnabled;
    private Map<String, Object> config;
}
