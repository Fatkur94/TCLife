package com.techcombank.tclife.common.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoalQuestionOptionResponse {
    private String optionId;
    private String value;
    private String label;
    private int sortOrder;
}
