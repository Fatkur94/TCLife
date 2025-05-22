package com.techcombank.tclife.leadService.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeadResponse {
    private String leadId;
    private String fullName;
    private LocalDate dob;
    private LocalDateTime creationDate;
    private Integer leadAging;
}