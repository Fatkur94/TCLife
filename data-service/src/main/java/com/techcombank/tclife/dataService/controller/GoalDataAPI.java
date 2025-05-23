package com.techcombank.tclife.dataService.controller;

import com.techcombank.tclife.dataService.model.GoalSummary;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "data-service", url = "${data-service.url}", path = "/api/data/goals")
public interface GoalDataAPI {
    @GetMapping("/active-list")
    List<GoalSummary> getActiveGoalSummaryList();
}
