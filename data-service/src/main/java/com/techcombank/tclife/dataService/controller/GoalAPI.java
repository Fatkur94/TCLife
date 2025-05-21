package com.techcombank.tclife.dataService.controller;

import com.techcombank.tclife.dataService.model.entity.dto.GoalQuestionResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/goal")
public interface GoalAPI {
    @GetMapping
    GoalQuestionResponseDto getQuestionsResponse();
}
