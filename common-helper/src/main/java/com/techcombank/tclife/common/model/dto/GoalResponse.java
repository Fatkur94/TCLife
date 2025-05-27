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
public class GoalResponse {
    private String goalId;
    private String title;
    private String description;
    private String imageUrl;
    private boolean isActive;
    private List<GoalQuestionResponse> questions;
}
