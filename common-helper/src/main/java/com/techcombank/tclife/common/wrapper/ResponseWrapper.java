package com.techcombank.tclife.common.wrapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.techcombank.tclife.common.base.BasePaginationResponse;
import com.techcombank.tclife.common.base.BaseListResponse;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseWrapper<T> {
    private final boolean success;
    private final T data;
    private final Integer page;
    private final Integer size;
    private final Long totalItems;
    private final Integer totalPages;

    public ResponseWrapper(boolean success, T data) {
        this.success = success;
        if (data instanceof BasePaginationResponse<?> paginationResponse) {
            this.data = (T) paginationResponse.getData();
            this.page = paginationResponse.getPage();
            this.size = paginationResponse.getSize();
            this.totalItems = paginationResponse.getTotalItems();
            this.totalPages = paginationResponse.getTotalPages();
        } else if (data instanceof BaseListResponse<?> listResponse) {
            this.data = (T) listResponse.getData();
            this.page = null;
            this.size = null;
            this.totalItems = null;
            this.totalPages = null;
        } else {
            this.data = data;
            this.page = null;
            this.size = null;
            this.totalItems = null;
            this.totalPages = null;
        }
    }
}