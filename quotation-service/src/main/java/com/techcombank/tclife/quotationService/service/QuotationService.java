package com.techcombank.tclife.quotationService.service;

import com.techcombank.tclife.common.util.JacksonUtil;
import com.techcombank.tclife.dataService.controller.GoalAPI;
import com.techcombank.tclife.dataService.model.entity.dto.GoalQuestionResponseDto;
import org.springframework.stereotype.Service;

@Service
public class QuotationService {
    private final GoalAPI goalAPI;

    private static final JacksonUtil jackson = JacksonUtil.createDefault();

    public QuotationService(GoalAPI goalAPI) {
        this.goalAPI = goalAPI;
    }

    public void goalQuestionnaireWorkflow() {
        GoalQuestionResponseDto goalQuestionResponseDto = goalAPI.getQuestionsResponse();
        System.out.println(jackson.toJson(goalQuestionResponseDto));
    }
}
