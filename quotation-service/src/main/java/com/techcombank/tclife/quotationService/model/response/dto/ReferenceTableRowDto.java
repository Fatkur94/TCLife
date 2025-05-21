package com.techcombank.tclife.quotationService.model.response.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReferenceTableRowDto {
    private String country;
    private String cost;
}
