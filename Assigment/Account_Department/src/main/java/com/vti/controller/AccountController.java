package com.vti.controller;

import com.vti.entity.Account;
import com.vti.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    @Autowired
    private IAccountService service;
    @GetMapping
   public Page<Account> findAll(Pageable pageable){
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Account findByID(@PathVariable Integer id){
        return service.findByID(id);
    }
    @GetMapping("/email/{email}")
    public Account findByEmail(@PathVariable String email){
        return service.findByEmail(email);
    }
    @PostMapping
    public void create(@RequestBody Account account){
        service.create(account);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id,@RequestBody Account account){
        account.setId(id);
        service.create(account);
    }
    public void updateByID(Integer id,String newName,Account account){
        account.setId(id);
        account.setFullName(newName);
        service.create(account);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }
    public boolean isAccountExistsByID(Integer id){
        return service.isAccountExistsByID(id);
    }
}
