package com.techcombank.tclife.common.model.mapper;

import com.techcombank.tclife.common.model.dto.GoalQuestionOptionResponse;
import com.techcombank.tclife.common.model.dto.GoalQuestionResponse;
import com.techcombank.tclife.common.model.dto.GoalResponse;
import com.techcombank.tclife.dataService.model.entity.Goal;
import com.techcombank.tclife.dataService.model.entity.GoalQuestion;
import com.techcombank.tclife.dataService.model.entity.GoalQuestionOption;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GoalMapper {

    @Mapping(source = "id", target = "goalId")
    GoalResponse toDto(Goal goal);

    @Mapping(source = "id", target = "questionId")
    GoalQuestionResponse toDto(GoalQuestion question);

    @Mapping(source = "id", target = "id")
    GoalQuestionOptionResponse toDto(GoalQuestionOption option);

    List<GoalQuestionResponse> toDtoQuestions(List<GoalQuestion> questions);

    List<GoalQuestionOptionResponse> toDtoOptions(List<GoalQuestionOption> options);
}

