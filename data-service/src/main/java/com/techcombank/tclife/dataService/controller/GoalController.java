package com.techcombank.tclife.dataService.controller;

import com.techcombank.tclife.dataService.model.entity.Goal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/data/goals")
public class GoalController implements GoalAPI {

    @Override
    public List<Goal> getGoals() {
        return List.of(
                new Goal(UUID.randomUUID(), "Education", "Education funding", "https://example.com/image.jpg", true, null),
                new Goal(UUID.randomUUID(), "Retirement", "Plan your retirement", "https://example.com/image2.jpg", true, null)
        );
    }
}
