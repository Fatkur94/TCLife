package com.techcombank.tclife.dataService.controller;

import com.techcombank.tclife.dataService.model.GoalSummary;
import com.techcombank.tclife.dataService.service.GoalDataService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/goals")
@AllArgsConstructor
public class GoalController {

    private final GoalDataService goalService;

    @GetMapping("/active-goals")
    public Page<GoalSummary> getActiveGoalSummaryList(
            @RequestParam int page,
            @RequestParam int size
    ) {
        return goalService.getActiveGoalsForSelection(PageRequest.of(page, size));
    }
}
