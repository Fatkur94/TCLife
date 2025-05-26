package com.techcombank.tclife.quotationService.service;

import com.techcombank.tclife.common.base.BasePaginationResponse;
import com.techcombank.tclife.common.wrapper.ClientResponseWrapper;
import com.techcombank.tclife.quotationService.model.response.GoalListItemResponse;

public interface QuotationService {
    BasePaginationResponse<GoalListItemResponse> loadGoalSelection(int page, int size);
    ClientResponseWrapper<Void> selectGoal(String goalId);
}
