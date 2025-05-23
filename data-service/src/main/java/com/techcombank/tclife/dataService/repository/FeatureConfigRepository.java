package com.techcombank.tclife.dataService.repository;

import com.techcombank.tclife.dataService.model.entity.FeatureConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FeatureConfigRepository extends JpaRepository<FeatureConfig, Long> {

    Optional<FeatureConfig> findByFeatureKeyAndScopeAndIsEnabledTrue(String featureKey, String scope);

}
