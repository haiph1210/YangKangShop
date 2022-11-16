package com.vti.slide08.service;

import com.vti.slide08.dto.AccountDTO;
import com.vti.slide08.entity.Account;
import com.vti.slide08.form.AccountCreateForm;
import com.vti.slide08.form.AccountFIlterForm;
import com.vti.slide08.form.AccountUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAccountService extends UserDetailsService {
    Page<Account> findAll(Pageable pageable, AccountFIlterForm form);

    Account findById(Integer id);


    Account findByUsername(String name);

    void create(AccountCreateForm form);

    void update(AccountUpdateForm form);

    void deleteById(Integer id);
}
