package com.techcombank.tclife.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class InsuranceFlowRequest<T> {
    private Context context;
    private T payload;
}
