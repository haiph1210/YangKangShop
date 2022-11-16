package com.YangKang.controller;

import com.YangKang.configuration.security.JWTTokenProvider;
import com.YangKang.form.AccountCreateForm;
import com.YangKang.payload.LoginRequest;
import com.YangKang.payload.LoginResponse;
import com.YangKang.payload.RamdomStuff;
import com.YangKang.service.CustomAccountDetail;
import com.YangKang.service.IAccountService;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    IAccountService accountService;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenProvider tokenProvider;
    @GetMapping("/login")
    public LoginResponse response (@Valid @RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.gennerateToken((CustomAccountDetail) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }
    @GetMapping("/register")
    public void register(@RequestBody AccountCreateForm form){
        accountService.create(form);
    }
    @GetMapping("/random")
    public RamdomStuff randomStuff(){
        return new RamdomStuff("JWT Hợp lệ mới có thể thấy được message này");
    }



}
