package com.techcombank.tclife.dataService.repository;

import com.techcombank.tclife.dataService.model.entity.FeatureConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeatureConfigRepository extends JpaRepository<FeatureConfig, Long> {
    Optional<FeatureConfig> findByFeatureNameAndScopeAndIsEnabledTrue(String featureName, String scope);
}
