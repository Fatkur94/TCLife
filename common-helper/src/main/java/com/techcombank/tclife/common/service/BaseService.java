package com.techcombank.tclife.common.service;

import com.techcombank.tclife.common.base.BaseRequest;
import com.techcombank.tclife.common.base.BaseResponse;

public interface BaseService<T extends BaseRequest, V extends BaseResponse> {
    ResponseWrapper<V> proceed(T input) throws Exception;

    default <T> ResponseWrapper<T> successResponse(T data) {
        return new ResponseWrapper<>(true, data);
    }
}
