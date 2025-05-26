package com.techcombank.tclife.common.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoalQuestionResponse {
    private String questionId;
    private String title;
    private String description;
    private String type;
    private String inputName;
    private String regex;
    private boolean isRepeatable;
    private boolean isRequired;
    private boolean isActive;
    private List<GoalQuestionOptionResponse> options;
    private List<GoalQuestionResponse> subQuestions;
}

