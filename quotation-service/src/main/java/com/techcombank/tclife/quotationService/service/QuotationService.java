package com.techcombank.tclife.quotationService.service;

import com.techcombank.tclife.common.constant.FeatureConfigConstants;
import com.techcombank.tclife.common.util.JacksonUtil;
import com.techcombank.tclife.dataService.controller.FeatureConfigDataAPI;
import com.techcombank.tclife.dataService.controller.GoalDataAPI;
import com.techcombank.tclife.dataService.model.GoalSummary;
import com.techcombank.tclife.dataService.model.dto.Request.FeatureConfigRequest;
import com.techcombank.tclife.quotationService.model.response.GoalListItemResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class QuotationService {

    private final GoalDataAPI goalAPI;
    private final FeatureConfigDataAPI featureConfigDataAPI;

    private static final JacksonUtil jackson = JacksonUtil.createDefault();

    public List<GoalListItemResponse> loadGoalSelection() {

        boolean isGoalListFromInsureMoEnabled = featureConfigDataAPI.getFeatureConfigByFeatureNameScope(
                new FeatureConfigRequest(
                        FeatureConfigConstants.ENABLE_INSUREMO + "_" + FeatureConfigConstants.SCOPE_GROUP,
                        FeatureConfigConstants.SCOPE_GLOBAL
                )
        ).isEnabled();

        if (isGoalListFromInsureMoEnabled) {
            // TODO : fetch goal from insureMo
            return List.of();
        }

        List<GoalSummary> goalSummaries = goalAPI.getActiveGoalSummaryList();
        return null;
    }
}
