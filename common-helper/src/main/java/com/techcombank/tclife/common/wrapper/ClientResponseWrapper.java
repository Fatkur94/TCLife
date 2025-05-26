package com.techcombank.tclife.common.wrapper;

import com.techcombank.tclife.common.model.Context;
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
    private Context context;

    public ClientResponseWrapper(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.context = null;
    }
}
