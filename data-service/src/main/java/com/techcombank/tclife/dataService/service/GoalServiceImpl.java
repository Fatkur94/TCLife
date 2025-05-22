package com.techcombank.tclife.dataService.service;

import com.techcombank.tclife.dataService.model.entity.Goal;
import com.techcombank.tclife.dataService.repository.GoalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GoalServiceImpl implements GoalService {

    private final GoalRepository goalRepository;

    @Override
    public List<Goal> getGoalsListSelection() {
        List<Goal> goals = goalRepository.findAll();
    }
}
