package com.techcombank.tclife.dataService.repository;

import com.techcombank.tclife.dataService.model.GoalSummary;
import com.techcombank.tclife.dataService.model.entity.Goal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GoalRepository extends JpaRepository<Goal, UUID> {

    @Query("""
        SELECT new com.techcombank.tclife.dataService.model.GoalSummary(g.id, g.title, g.description, g.imageUrl)
        FROM Goal g
        WHERE g.isActive = true
    """)
    Page<GoalSummary> findAllActiveGoalsAsSummary(Pageable pageable);


}
