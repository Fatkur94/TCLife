package com.techcombank.tclife.leadService.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetLeadsResponse {
    private String leadId;
    private String fullName;
    private Date dob;
    private Date creationDate;
    private Integer leadAging;
}