package com.techcombank.tclife.dataService.model.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReferenceInfoDto {
    private String title;
    private SourceDto source;
    private String note;
    private ReferenceTableDto table;
}
