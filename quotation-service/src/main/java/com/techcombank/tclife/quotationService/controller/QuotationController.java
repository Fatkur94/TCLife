package com.techcombank.tclife.quotationService.controller;

import com.techcombank.tclife.quotationService.model.response.GoalListItemResponse;
import com.techcombank.tclife.quotationService.service.QuotationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Quotation APIs", description = "APIs for insurance quotation")
@RequiredArgsConstructor
@Validated
public class QuotationController {

    private final QuotationService quotationService;

    @GetMapping("/goals/active-goals")
    public ResponseEntity<List<GoalListItemResponse>> getAllActiveGoals() {
        List<GoalListItemResponse> goalListItemResponses = quotationService.loadGoalSelection();
        return ResponseEntity.ok(goalListItemResponses);
    }
}
