package com.techcombank.tclife.quotationService.model.response.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GoalQuestionResponseDto {
    private String goalId;
    private String goalTitle;
    private String goalBanner;
    private List<QuestionDto> questions;
}
