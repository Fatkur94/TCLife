package com.techcombank.tclife.dataService.service;

import com.techcombank.tclife.common.model.dto.GoalResponse;
import com.techcombank.tclife.dataService.model.GoalSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface GoalDataService {
    Page<GoalSummary> getActiveGoalsForSelection(Pageable pageable);
    GoalResponse getGoalByGoalId(@Param("goalId") UUID goalId);
}
