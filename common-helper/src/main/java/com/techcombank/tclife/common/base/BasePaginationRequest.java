package com.techcombank.tclife.common.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BasePaginationRequest extends BaseRequest{
    private Integer page;
    private Integer size;
    private String sortBy;
}
