package com.vti.controller;

import com.vti.entity.Account;
import com.vti.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//  /api/v1/accounts
//
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    @Autowired  // tự động tăng
    private IAccountService service;

    @GetMapping
    public List<Account> findAll() {
        return service.findAll();
    }
    @GetMapping("/{id}")
    public Account findByID(@PathVariable int id) {
        return service.findByID(id);
    }

    @GetMapping("/name/{name}")
    public Account findByName(@PathVariable String name) {
        return service.findByName(name);
    }
    @PostMapping
    public void createAccount(@RequestBody Account account) {
        service.createAccount(account);
    }
    @PutMapping("/{id}")
    public void updateAccount(@PathVariable int id, @RequestBody Account account) {
        service.updateAccount(account);
    }

    @DeleteMapping("/{id}")
    public void deleteByID(@PathVariable int id) {
        service.deleteByID(id);
    }


    public void deletebyName(String name) {
        service.deletebyName(name);
    }
}
