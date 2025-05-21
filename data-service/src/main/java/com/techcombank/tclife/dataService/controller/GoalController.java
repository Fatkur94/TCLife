package com.techcombank.tclife.dataService.controller;

import com.techcombank.tclife.dataService.model.entity.dto.GoalQuestionResponseDto;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoalController implements GoalAPI {

    @Override
    public GoalQuestionResponseDto getQuestionsResponse() {
        return null;
    }
}
