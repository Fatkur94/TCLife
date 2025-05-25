package com.techcombank.tclife.leadService.model.request;

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
    private String leadId;
}
