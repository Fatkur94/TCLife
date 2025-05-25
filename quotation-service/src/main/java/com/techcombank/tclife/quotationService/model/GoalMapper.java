package com.techcombank.tclife.quotationService.model;

import com.techcombank.tclife.dataService.model.GoalSummary;
import com.techcombank.tclife.quotationService.model.response.GoalListItemResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface GoalMapper {
    GoalListItemResponse toDto(GoalSummary goalSummary);
    List<GoalListItemResponse> toDtoList(List<GoalSummary> summaries);
}
