package com.techcombank.tclife.dataService.model.request;

import com.techcombank.tclife.common.base.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetLeadDetailRequest extends BaseRequest {
    private String id;
}
