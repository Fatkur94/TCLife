package com.techcombank.tclife.quotationService.controller;

import com.techcombank.tclife.authService.model.request.AccessRequest;
import com.techcombank.tclife.common.base.BasePaginationResponse;
import com.techcombank.tclife.common.model.Context;
import com.techcombank.tclife.common.model.InsuranceFlowRequest;
import com.techcombank.tclife.common.util.CommonUtil;
import com.techcombank.tclife.common.wrapper.ClientResponseWrapper;
import com.techcombank.tclife.common.wrapper.ResponseWrapper;
import com.techcombank.tclife.quotationService.client.AuthClient;
import com.techcombank.tclife.quotationService.model.request.SubmitGoalSelection;
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
    private final AuthClient authClient;

    @PostMapping("/fna/get-active-goals")
    public ResponseEntity<ResponseWrapper<BasePaginationResponse<GoalListItemResponse>>> getAllActiveGoals(
            @RequestHeader("Authorization") String bearerToken,
            @RequestBody InsuranceFlowRequest<Void> request,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        ResponseEntity<ClientResponseWrapper<Void>> authorized = authClient.authorize(
                bearerToken,
                new AccessRequest("fna", "read")
        );
        if (!authorized.getBody().isSuccess()) return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

        String pitchSessionId = CommonUtil.generateContextToken();
        Context context = Context.builder()
                .leadId(request.getContext().getLeadId())
                .pitchSessionId(pitchSessionId)
                .build();
        BasePaginationResponse<GoalListItemResponse> goalSelection = quotationService.loadGoalSelection(page, size);
        return ResponseEntity.ok(new ResponseWrapper<>(true, goalSelection, context));
    }

    @PostMapping("/fna/submit-goal")
    public ResponseEntity<ClientResponseWrapper<Void>> submitGoal(
            @RequestHeader("Authorization") String bearerToken,
            @RequestBody InsuranceFlowRequest<SubmitGoalSelection> request
    ) {
        ResponseEntity<ClientResponseWrapper<Void>> authorized = authClient.authorize(
                bearerToken,
                new AccessRequest("fna", "read")
        );
        if (!authorized.getBody().isSuccess()) return ResponseEntity.status(HttpStatus.FORBIDDEN).build();



        return ResponseEntity.ok(new ClientResponseWrapper<>(true, "Goal successfully selected", null, request.getContext()));
    }
}
