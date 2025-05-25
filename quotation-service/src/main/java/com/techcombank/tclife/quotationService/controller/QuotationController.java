package com.techcombank.tclife.quotationService.controller;

import com.techcombank.tclife.authService.service.AuthorizationService;
import com.techcombank.tclife.common.base.BasePaginationResponse;
import com.techcombank.tclife.common.wrapper.ResponseWrapper;
import com.techcombank.tclife.quotationService.model.response.GoalListItemResponse;
import com.techcombank.tclife.quotationService.service.QuotationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/quotation")
@Tag(name = "Quotation APIs", description = "APIs for insurance quotation")
@RequiredArgsConstructor
@Validated
public class QuotationController {

    private final QuotationService quotationService;
    private final AuthorizationService authorizationService;

    @GetMapping("/fna/get-active-goals")
    public ResponseEntity<ResponseWrapper<BasePaginationResponse<GoalListItemResponse>>> getAllActiveGoals(
            @RequestHeader("Authorization") String bearerToken,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        boolean authorized = authorizationService.isAuthorized(bearerToken, "quotation", "read");
        if (!authorized) return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

        BasePaginationResponse<GoalListItemResponse> goalSelection = quotationService.loadGoalSelection(page, size);
        return ResponseEntity.ok(new ResponseWrapper<>(true, goalSelection));
    }
}
