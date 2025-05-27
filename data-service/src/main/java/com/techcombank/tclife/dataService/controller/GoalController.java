package com.techcombank.tclife.dataService.controller;

import com.techcombank.tclife.common.model.dto.GoalResponse;
import com.techcombank.tclife.common.wrapper.ClientResponseWrapper;
import com.techcombank.tclife.dataService.model.GoalSummary;
import com.techcombank.tclife.dataService.service.GoalDataService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/goals")
@AllArgsConstructor
public class GoalController {

    private final GoalDataService goalDataService;

    // TODO: use ClientResponseWrapper.
    @GetMapping("/active-goals")
    public Page<GoalSummary> getActiveGoalSummaryList(
            @RequestParam int page,
            @RequestParam int size
    ) {
        return goalDataService.getActiveGoalsForSelection(PageRequest.of(page, size));
    }

    @GetMapping("/get-goal-by-goal-id")
    public ResponseEntity<ClientResponseWrapper<GoalResponse>> getGoalByGoalId(@RequestParam String goalId) {
        try {
            GoalResponse response = goalDataService.getGoalByGoalId(UUID.fromString(goalId));

            if (response != null) {
                return ResponseEntity.ok(new ClientResponseWrapper<>(true, "Goal retrieved successfully", response));
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(new ClientResponseWrapper<>(false, "Goal not found with ID: " + goalId, null));
            }

        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ClientResponseWrapper<>(false, "Invalid UUID format: " + e.getMessage(), null));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ClientResponseWrapper<>(false, "Error retrieving goal: " + e.getMessage(), null));
        }
    }

}
