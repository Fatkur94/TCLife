package com.techcombank.tclife.dataService.controller;

import com.techcombank.tclife.dataService.model.entity.Goal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "data-service", url = "${data-service.url}", path = "/api/data/goals")
public interface GoalAPI {
    @GetMapping
    List<Goal> getGoals();
}
