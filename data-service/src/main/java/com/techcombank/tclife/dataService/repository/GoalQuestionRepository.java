package com.techcombank.tclife.dataService.repository;

import com.techcombank.tclife.dataService.model.entity.GoalQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GoalQuestionRepository extends JpaRepository<GoalQuestion, UUID> {

    List<GoalQuestion> findByGoalId(UUID goalId);

    List<GoalQuestion> findByParentQuestionId(UUID parentQuestionId);

    List<GoalQuestion> findByGoalIdAndIsActiveTrue(UUID goalId);

}
