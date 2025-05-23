package com.techcombank.tclife.authService.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter @Getter
public class AuthResponse {
    public boolean success;
    public String message;
    public String token;
    public boolean newPasswordRequired;

    public AuthResponse(boolean success, String message, String token, boolean newPasswordRequired) {
        this.success = success;
        this.message = message;
        this.token = token;
        this.newPasswordRequired = newPasswordRequired;
    }
}
