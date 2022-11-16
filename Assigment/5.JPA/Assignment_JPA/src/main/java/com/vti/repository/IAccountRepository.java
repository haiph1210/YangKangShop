package com.vti.repository;

import com.vti.entity.Account;

import java.util.List;

public interface IAccountRepository {
    List<Account> findAll();

    Account findByID(int id);

    Account findByName(String name);

    void createAccount(Account account);

    void updateAccount(Account account);

    void deleteByID(int id);

    void deletebyName(String name);
}
