package com.YangKang.payload;

import com.YangKang.entity.Account;
import lombok.Data;

@Data
public class LoginResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private String role ;

    public LoginResponse(String accessToken) {
        this.accessToken = accessToken;

    }

//    public LoginResponse(String accessToken, Account.Role role) {
//        this.accessToken = accessToken;
//        this.role = role;
//    }
}
