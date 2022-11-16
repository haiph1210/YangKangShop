package com.YangKang.controller;

import com.YangKang.dto.AccountDTO;
import com.YangKang.entity.Account;
import com.YangKang.form.AccountCreateForm;
import com.YangKang.form.AccountFillterForm;
import com.YangKang.form.AccountUpdateForm;
import com.YangKang.service.IAccountService;
import com.YangKang.validation.AccountExistByUserName;
import com.YangKang.validation.AccountExistsById;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Validated
@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    @Autowired
    private IAccountService service;
    @Autowired
    private ModelMapper mapper;

    @GetMapping
    public Page<AccountDTO> findAll(Pageable pageable, AccountFillterForm form){
        Page<Account> page  = service.findAll(pageable,form);
        List<Account> accounts = page.getContent();
        List<AccountDTO> dto = mapper.map(accounts,new TypeToken<List<AccountDTO>>(){}.getType());
        return new PageImpl<>(dto,pageable,page.getTotalPages());
    }

    @GetMapping("/{id}")
    public AccountDTO findById(@PathVariable @AccountExistsById Integer id){
        Account account = service.findById(id);
        return mapper.map(account, AccountDTO.class);

    }

    @GetMapping("/username/{username}")
    public AccountDTO findByUsername(@PathVariable @AccountExistByUserName String username){
        Account account = service.findByUsername(username);
        return mapper.map(account, AccountDTO.class);
    }

    @PostMapping()
    public void create(@Validated  @RequestBody AccountCreateForm form){
        service.create(form);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable @AccountExistsById Integer id, @RequestBody @Valid AccountUpdateForm form){
        form.setId(id);
        service.update(form);
    }

    @DeleteMapping("/{id}")
    public void deleleById(@PathVariable @AccountExistsById Integer id){
        service.deleteById(id);
    }

    @DeleteMapping
    public void deleteAll(@RequestBody   List< @AccountExistsById Integer> ids){
        service.deleteAll(ids);
    }

}
