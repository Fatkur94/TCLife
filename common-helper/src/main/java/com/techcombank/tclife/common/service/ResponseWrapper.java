package com.techcombank.tclife.common.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.techcombank.tclife.common.base.BasePaginationResponse;
import lombok.Data;

import java.util.List;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseWrapper<T> {
    private final boolean success;
    private final List<?> data;
    private final Integer page;
    private final Integer size;
    private final Long totalItems;
    private final Integer totalPages;

    public ResponseWrapper(boolean success, T data) {
        this.success = success;
        if (data instanceof BasePaginationResponse<?> paginationResponse) {
            this.data = paginationResponse.getData();
            this.page = paginationResponse.getPage();
            this.size = paginationResponse.getSize();
            this.totalItems = paginationResponse.getTotalItems();
            this.totalPages = paginationResponse.getTotalPages();
        } else {
            this.data = null;
            this.page = null;
            this.size = null;
            this.totalItems = null;
            this.totalPages = null;
        }
    }
}