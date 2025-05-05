package com.techcombank.tclife.common.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BasePaginationRequest extends BaseRequest{
    private Integer page;
    private Integer size;
    private String sortBy;

    public int getPageOrDefault() {
        return (page != null && page >= 1) ? page : 1;
    }

    public int getSizeOrDefault() {
        return (size != null && size > 0) ? size : 10;
    }
    public Pageable toPageable() {
        int pageNumber = getPageOrDefault() - 1;
        int pageSize = getSizeOrDefault();
        if (sortBy != null && !sortBy.isEmpty()) {
            return PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        }
        return PageRequest.of(pageNumber, pageSize);
    }
}
