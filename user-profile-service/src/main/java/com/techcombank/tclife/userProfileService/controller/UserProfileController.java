package com.techcombank.tclife.userProfileService.controller;

import com.techcombank.tclife.common.model.EmptyRequest;
import com.techcombank.tclife.common.wrapper.ResponseWrapper;
import com.techcombank.tclife.userProfileService.model.response.GetUserProfileResponse;
import com.techcombank.tclife.userProfileService.service.GetUserProfileService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-profile-service/api/v1")
public class UserProfileController {

    private GetUserProfileService getUserProfileService;

    public UserProfileController(GetUserProfileService getUserProfileService) {
        this.getUserProfileService = getUserProfileService;
    }

    @GetMapping(value="/sales/profile")
    public ResponseWrapper<GetUserProfileResponse> getUserProfile(EmptyRequest request) {
        return getUserProfileService.proceed(request);
    }

}
