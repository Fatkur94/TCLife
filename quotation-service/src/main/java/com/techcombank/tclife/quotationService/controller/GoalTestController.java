package com.techcombank.tclife.quotationService.controller;

import com.techcombank.tclife.dataService.model.entity.Goal;
import com.techcombank.tclife.quotationService.service.QuotationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class GoalTestController {

    private final QuotationService quotationService;

    public GoalTestController(QuotationService quotationService) {
        this.quotationService = quotationService;
    }

    @GetMapping("/goals")
    public void testGoals() {
        quotationService.goalQuestionnaireWorkflow();
    }
}
