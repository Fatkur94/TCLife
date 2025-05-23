package com.techcombank.tclife.dataService.model.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
public class FeatureConfigRequest {
    private String featureName;
    private String scope;
}
