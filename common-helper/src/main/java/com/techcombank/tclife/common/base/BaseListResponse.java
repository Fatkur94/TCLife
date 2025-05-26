package com.techcombank.tclife.common.base;

import java.util.List;

public class BaseListResponse<T> extends BaseResponse {
    private List<T> data;

    public BaseListResponse(List<T> data) {
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
