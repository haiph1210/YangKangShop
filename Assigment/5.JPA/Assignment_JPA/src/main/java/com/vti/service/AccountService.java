package com.vti.service;

import com.vti.entity.Account;
import com.vti.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountService implements IAccountService{
    @Autowired // tự động tạo mới
    private IAccountRepository repository;
    @Override
    public List<Account> findAll() {
        return repository.findAll();
    }

    @Override
    public Account findByID(int id) {
        return repository.findByID(id);
    }

    @Override
    public Account findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void createAccount(Account account) {
        repository.createAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        repository.updateAccount(account);
    }

    @Override
    public void deleteByID(int id) {
        repository.deleteByID(id);
    }

    @Override
    public void deletebyName(String name) {
        repository.deletebyName(name);
    }
}
