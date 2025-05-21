package com.techcombank.tclife.dataService.model.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReferenceTableDto {
    private List<String> headers;
    private List<ReferenceTableRowDto> rows;
}
