package com.techcombank.tclife.dataService.service;

import com.techcombank.tclife.dataService.model.GoalSummary;
import com.techcombank.tclife.dataService.repository.GoalRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GoalDataServiceImpl implements GoalDataService {

    private final GoalRepository goalRepository;

    @Override
    public Page<GoalSummary> getActiveGoalsForSelection(Pageable pageable) {
        return goalRepository.findAllActiveGoalsAsSummary(pageable);
    }
}
