package com.techcombank.tclife.dataService.controller;

import com.techcombank.tclife.dataService.model.GoalSummary;
import com.techcombank.tclife.dataService.service.GoalDataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/data/goals")
@AllArgsConstructor
public class GoalController implements GoalDataAPI {

    private final GoalDataService goalService;

    @Override
    public List<GoalSummary> getActiveGoalSummaryList() {
        return goalService.getActiveGoalsForSelection();
    }
}
