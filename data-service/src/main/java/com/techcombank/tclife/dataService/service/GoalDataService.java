package com.techcombank.tclife.dataService.service;

import com.techcombank.tclife.dataService.model.GoalSummary;

import java.util.List;

public interface GoalDataService {
    List<GoalSummary> getActiveGoalsForSelection();
}
