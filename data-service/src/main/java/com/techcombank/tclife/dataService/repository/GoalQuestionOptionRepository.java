package com.techcombank.tclife.dataService.repository;

import com.techcombank.tclife.dataService.model.entity.GoalQuestionOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GoalQuestionOptionRepository extends JpaRepository<GoalQuestionOption, UUID> {
    List<GoalQuestionOption> findByQuestionIdOrderBySortOrderAsc(UUID questionId);
}
