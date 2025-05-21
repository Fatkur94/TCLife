package com.techcombank.tclife.dataService.controller;

import com.techcombank.tclife.dataService.model.entity.Goal;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoalController implements GoalAPI {

    @Override
    public List<Goal> getGoals() {
        return List.of();
    }
}
