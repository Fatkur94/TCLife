package com.techcombank.tclife.dataService.service;

import com.techcombank.tclife.dataService.model.GoalSummary;
import com.techcombank.tclife.dataService.repository.GoalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GoalDataServiceImpl implements GoalDataService {

    private final GoalRepository goalRepository;

    @Override
    public List<GoalSummary> getActiveGoalsForSelection() {
        return goalRepository.findAllActiveGoalsAsSummary();
    }
}
