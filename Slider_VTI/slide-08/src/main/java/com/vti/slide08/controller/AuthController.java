package com.vti.slide08.controller;

import com.vti.slide08.dto.ProfileDTO;
import com.vti.slide08.entity.Account;
import com.vti.slide08.form.AccountCreateForm;
import com.vti.slide08.repository.IAccountRepository;
import com.vti.slide08.service.IAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private IAccountService service;
    @Autowired
    private ModelMapper mapper;

    @GetMapping("/login")
    public ProfileDTO login(Principal principal){
        String username = principal.getName();
        Account account = service.findByUsername(username);
        return mapper.map(account,ProfileDTO.class);
    }

    @PostMapping("/register")
    public void register(@RequestBody AccountCreateForm form){
        service.create(form );
    }

}
