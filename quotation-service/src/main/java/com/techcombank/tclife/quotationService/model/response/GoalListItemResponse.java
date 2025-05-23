package com.techcombank.tclife.quotationService.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GoalListItemResponse {
    private String goalId;
    private String goalTitle;
    private String goalBanner;
    private String description;
}
