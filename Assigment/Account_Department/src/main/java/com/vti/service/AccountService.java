package com.vti.service;

import com.vti.entity.Account;
import com.vti.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository repository ;

    public Page<Account> findAll(Pageable pageable){
       return repository.findAll(pageable);
    }
    @Override
    public Account findByID(Integer id){
        return repository.findById(id).orElse(null);
    }
    @Override
    public Account findByEmail(String email){
        return repository.findByEmail(email);
    }
    @Override
    public void create(Account account){
        repository.save(account);
    }
    @Override
    public void update(Integer id, Account account){
        account.setId(id);
        repository.save(account);
    }
    @Override
    public void updateByID(Integer id, String newName, Account account){
        account.setId(id);
        account.setFullName(newName);
        repository.save(account);
    }
    @Override
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
    @Override
    public boolean isAccountExistsByID(Integer id){
        return repository.existsById(id);
    }
//    public boolean isAccountExistsByName(String name){
//        return repository.exists(name);
//    }
}
