package com.techcombank.tclife.common.service;

import com.techcombank.tclife.common.base.BaseRequest;
import com.techcombank.tclife.common.base.BaseResponse;
import com.techcombank.tclife.common.wrapper.ResponseWrapper;

public interface BaseService<T extends BaseRequest, V extends BaseResponse> {
    ResponseWrapper<V> proceed(T input);

    default <T> ResponseWrapper<T> successResponse(T data) {
        return new ResponseWrapper<>(true, data, null); // TODO : adjust this as needed.
    }
}
