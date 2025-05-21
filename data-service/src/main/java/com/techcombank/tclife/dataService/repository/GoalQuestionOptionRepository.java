package com.techcombank.tclife.dataService.repository;

import com.techcombank.tclife.dataService.model.entity.GoalQuestionOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GoalQuestionOptionRepository extends JpaRepository<GoalQuestionOption, UUID> {

    List<GoalQuestionOption> findByQuestionIdOrderBySortOrderAsc(UUID questionId);

}
