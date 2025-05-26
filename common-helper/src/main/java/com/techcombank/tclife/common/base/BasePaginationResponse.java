package com.techcombank.tclife.common.base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.techcombank.tclife.common.model.Context;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasePaginationResponse<T> extends BaseResponse {
    private List<T> data;
    private Context context;
    private int page;
    private int size;
    private long totalItems;
    private int totalPages;

    public BasePaginationResponse(List<T> data, Context context, int page, int size, long totalItems, int totalPages) {
        this.data = (data != null) ? data : Collections.emptyList();
        this.context = context;
        this.page = page;
        this.size = size;
        this.totalItems = totalItems;
        this.totalPages = totalPages;
    }

    public BasePaginationResponse() {
        this.data = Collections.emptyList();
    }
}



