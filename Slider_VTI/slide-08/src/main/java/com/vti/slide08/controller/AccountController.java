package com.vti.slide08.controller;

import com.vti.slide08.dto.AccountDTO;
import com.vti.slide08.entity.Account;
import com.vti.slide08.form.AccountCreateForm;
import com.vti.slide08.form.AccountFIlterForm;
import com.vti.slide08.form.AccountUpdateForm;
import com.vti.slide08.repository.IAccountRepository;
import com.vti.slide08.service.IAccountService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    @Autowired
    private IAccountService service;
    @Autowired
    private ModelMapper mapper;
    @GetMapping
    public Page<AccountDTO> findAll(Pageable pageable, AccountFIlterForm form){
        Page<Account> page = service.findAll(pageable,form);
        List<Account> accounts = page.getContent();
        List<AccountDTO> dtos = mapper.map(accounts,new TypeToken<List<AccountDTO>>(){}.getType());
        return new PageImpl<>(dtos,pageable,page.getTotalPages());
    }
    @GetMapping("/{id}")
    public AccountDTO findById(@PathVariable Integer id){
        Account account = service.findById(id);
        return mapper.map(account,AccountDTO.class);
    }
    @GetMapping("/name/{name}")
    public Account findByName(@PathVariable String name){
        return service.findByUsername(name);
    }
    @PostMapping
    public void create(@RequestBody AccountCreateForm form){
        service.create(form);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id,@RequestBody AccountUpdateForm form){
        form.setId(id);
        service.update(form);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }
}
