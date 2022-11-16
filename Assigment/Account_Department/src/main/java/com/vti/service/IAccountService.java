package com.vti.service;

import com.vti.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAccountService {
    Page<Account> findAll(Pageable pageable);
    Account findByID(Integer id);

    Account findByEmail(String email);

    void create(Account account);

    void update(Integer id, Account account);

    void updateByID(Integer id, String newName, Account account);

    void deleteById(Integer id);
    boolean isAccountExistsByID(Integer id);



}
