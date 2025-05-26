package com.techcombank.tclife.quotationService.service;

import com.techcombank.tclife.common.base.BasePaginationResponse;
import com.techcombank.tclife.common.constant.FeatureConfigConstants;
import com.techcombank.tclife.common.util.JacksonUtil;
import com.techcombank.tclife.common.wrapper.ClientResponseWrapper;
import com.techcombank.tclife.dataService.model.GoalSummary;
import com.techcombank.tclife.dataService.model.dto.Request.FeatureConfigRequest;
import com.techcombank.tclife.quotationService.client.FeatureConfigDataClient;
import com.techcombank.tclife.quotationService.client.GoalDataClient;
import com.techcombank.tclife.quotationService.client.LeadDataClient;
import com.techcombank.tclife.quotationService.model.response.GoalListItemResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuotationServiceImpl implements QuotationService {

    private final GoalDataClient goalDataClient;
    private final FeatureConfigDataClient featureConfigDataClient;
    private final LeadDataClient leadDataClient;

    private static final JacksonUtil jackson = JacksonUtil.createDefault();

    @Override
    public BasePaginationResponse<GoalListItemResponse> loadGoalSelection(int page, int size) {

        boolean isGoalListFromInsureMoEnabled = featureConfigDataClient.getFeatureConfigByFeatureNameScope(
                new FeatureConfigRequest(
                        FeatureConfigConstants.ENABLE_INSUREMO + "_" + FeatureConfigConstants.SCOPE_GROUP,
                        FeatureConfigConstants.SCOPE_GLOBAL
                )
        ).isEnabled();

        if (isGoalListFromInsureMoEnabled) {
            // TODO: fetch from InsureMo
            return null;
        }

        Page<GoalSummary> goalSummaries = goalDataClient.getActiveGoalSummaryList(page, size);
        List<GoalListItemResponse> content = goalSummaries.getContent().stream()
                .map(this::convertToGoalListItemResponse)
                .toList();

        return new BasePaginationResponse<>(
                content, page, size,
                goalSummaries.getTotalElements(),
                goalSummaries.getTotalPages()
        );
    }

    @Override
    public ClientResponseWrapper<Void> selectGoal(String goalId) {

        goalDataClient.getGoalByGoalId(goalId);


        return null;
    }

    private GoalListItemResponse convertToGoalListItemResponse(GoalSummary goal) {
        return new GoalListItemResponse(
                goal.getId().toString(),
                goal.getTitle(),
                goal.getDescription(),
                goal.getImageUrl()
        );
    }


}
