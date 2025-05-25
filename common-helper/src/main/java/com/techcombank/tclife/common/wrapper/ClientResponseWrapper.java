package com.techcombank.tclife.common.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientResponseWrapper<T> {
    private boolean success;
    private String message;
    private T data;
}
