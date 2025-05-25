package com.techcombank.tclife.quotationService.service;

import com.techcombank.tclife.common.base.BasePaginationResponse;
import com.techcombank.tclife.quotationService.model.response.GoalListItemResponse;

public interface QuotationService {
    BasePaginationResponse<GoalListItemResponse> loadGoalSelection(int page, int size);
}
