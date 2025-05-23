package com.techcombank.tclife.authService.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter
public class RegisterRequest {
    public String email;
    public String password;
    public String userType; // "sales" or "customer"
}
