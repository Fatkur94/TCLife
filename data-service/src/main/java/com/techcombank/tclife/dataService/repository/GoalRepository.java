package com.techcombank.tclife.dataService.repository;

import com.techcombank.tclife.dataService.model.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GoalRepository extends JpaRepository<Goal, UUID> {

    List<Goal> findByIsActiveTrue();

}
