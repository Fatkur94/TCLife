package com.techcombank.tclife.authService.model.response;

import com.techcombank.tclife.common.base.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HelloResponse extends BaseResponse {
    private String cardStatus;
    private String postalCode;
    private String productCode;
    private Boolean isMainCard;
    private Boolean supplementaryOwned;
}
