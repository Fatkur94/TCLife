package com.techcombank.tclife.authService.model.request;

import com.techcombank.tclife.common.base.BasePaginationRequest;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserRequest extends BasePaginationRequest {
    private String name;
}
