package com.techcombank.tclife.dataService.service;

import com.techcombank.tclife.dataService.model.GoalSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GoalDataService {
    Page<GoalSummary> getActiveGoalsForSelection(Pageable pageable);
}
