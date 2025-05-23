package com.techcombank.tclife.dataService.service;

import com.techcombank.tclife.dataService.model.entity.FeatureConfig;

public interface FeatureConfigDataService {
    FeatureConfig getFeatureConfigByFeatureNameScope(String featureName, String scope);
}
