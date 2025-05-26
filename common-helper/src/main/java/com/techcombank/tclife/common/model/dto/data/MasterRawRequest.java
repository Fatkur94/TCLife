package com.techcombank.tclife.common.model.dto.data;

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
