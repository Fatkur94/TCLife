package com.techcombank.tclife.common.service;

import lombok.Data;

@Data
public class ResponseWrapper<T> {
    private final boolean success;
    private final T data;

    public ResponseWrapper(boolean success, T data) {
        this.success = success;
        this.data = data;
    }
}