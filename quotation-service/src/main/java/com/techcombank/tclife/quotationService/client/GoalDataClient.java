package com.techcombank.tclife.quotationService.client;

import com.techcombank.tclife.dataService.model.GoalSummary;
import com.techcombank.tclife.dataService.model.entity.Goal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "goal-data", url = "${integration.portal.data-service.base-url}", path = "/api/v1/goals")
public interface GoalDataClient {
    @GetMapping("/active-goals")
    Page<GoalSummary> getActiveGoalSummaryList(@RequestParam("page") int page, @RequestParam("size") int size);

    @GetMapping("/get-goal-by-goal-id")
    Goal getGoalByGoalId(String goalId);
}
