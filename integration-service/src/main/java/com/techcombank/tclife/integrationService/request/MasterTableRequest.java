package com.techcombank.tclife.integrationService.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MasterTableRequest {
    private String tableCd;
    private String language;
}
