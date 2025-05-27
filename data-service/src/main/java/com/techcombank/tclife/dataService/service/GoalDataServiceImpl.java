package com.techcombank.tclife.dataService.service;

import com.techcombank.tclife.common.model.dto.GoalResponse;
import com.techcombank.tclife.common.model.mapper.GoalMapper;
import com.techcombank.tclife.dataService.model.GoalSummary;
import com.techcombank.tclife.dataService.model.entity.Goal;
import com.techcombank.tclife.dataService.repository.GoalRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.resource.NoResourceFoundException;

import java.util.UUID;

@Service
@AllArgsConstructor
public class GoalDataServiceImpl implements GoalDataService {

    private final GoalRepository goalRepository;
    private final GoalMapper goalMapper;

    @Override
    public Page<GoalSummary> getActiveGoalsForSelection(Pageable pageable) {
        return goalRepository.findAllActiveGoalsAsSummary(pageable);
    }

    @Override
    public GoalResponse getGoalByGoalId(UUID goalId) {
        Goal goal = goalRepository.findGoalWithQuestionsById(goalId)
                .orElseThrow(() -> new NoResourceFoundException("Goal not found with ID: " + goalId));

        return goalMapper.toDto(goal);
    }


}
