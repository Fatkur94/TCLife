package com.techcombank.tclife.dataService.service;

import com.techcombank.tclife.dataService.model.entity.FeatureConfig;
import com.techcombank.tclife.dataService.repository.FeatureConfigRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FeatureConfigDataServiceImpl implements FeatureConfigDataService {

    private final FeatureConfigRepository featureConfigRepository;

    @Override
    public FeatureConfig getFeatureConfigByFeatureNameScope(String featureName, String scope) {
        return featureConfigRepository.findByFeatureKeyAndScopeAndIsEnabledTrue(featureName, scope)
                .orElseThrow(() -> new EntityNotFoundException(
                        "FeatureConfig not found for feature: " + featureName + " and scope: " + scope));
    }
}
