package com.techcombank.tclife.common.base;

import com.techcombank.tclife.common.model.Context;

import java.util.List;

public class BaseListResponse<T> extends BaseResponse {
    private List<T> data;
    private Context context;

    public BaseListResponse(List<T> data, Context context) {
        this.data = data;
        this.context = context;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
