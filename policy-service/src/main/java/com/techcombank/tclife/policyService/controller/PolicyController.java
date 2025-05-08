package com.techcombank.tclife.policyService.controller;

import com.techcombank.tclife.policyService.dto.PolicyListDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("policy-service")
@RequiredArgsConstructor
@Tag(name = "Policy Management", description = "APIs for managing policy")
public class PolicyController {

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }

    @Operation(summary = "")
    @GetMapping("policyList/{agentCd}")
    public ResponseEntity<PolicyListDTO>getPolicyList(
            @PathVariable("agentCd") String agentCd,
            @RequestParam("page") int page,
            @RequestParam("size") int size){
        Pageable pageable = PageRequest.of(page, size);
        return null;
    }
}
