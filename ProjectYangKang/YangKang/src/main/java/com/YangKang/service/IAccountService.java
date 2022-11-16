package com.YangKang.service;

import com.YangKang.entity.Account;
import com.YangKang.form.AccountCreateForm;
import com.YangKang.form.AccountFillterForm;
import com.YangKang.form.AccountUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IAccountService extends UserDetailsService {
    Page<Account> findAll(Pageable pageable, AccountFillterForm form);

    Account findById(Integer id);

    Account findByUsername(String username);

    void create(AccountCreateForm account);

    void update(AccountUpdateForm account);

    void deleteById(Integer id);

    void deleteAll(List<Integer> ids);


    UserDetails loadUserById(Integer userId);
}
