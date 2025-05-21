package com.techcombank.tclife.dataService.model.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MasterRawRequest {
    private String tableCd;
    private String language;
}
