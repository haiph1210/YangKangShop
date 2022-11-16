package com.YangKang.service;


import com.YangKang.entity.Account;
import com.YangKang.form.AccountCreateForm;
import com.YangKang.form.AccountFillterForm;
import com.YangKang.form.AccountUpdateForm;
import com.YangKang.repository.IAccountRepository;
import com.YangKang.specifition.AccountSpeacifition;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<Account> findAll(Pageable pageable, AccountFillterForm form){
        Specification<Account> specification = AccountSpeacifition.buildWhere(form);
        return repository.findAll(specification,pageable);
    }

    @Override
    public Account findById(Integer id){
        return repository.findById(id).orElse(null);
    }

    @Override
    public Account findByUsername(String username){
        return repository.findByUsername(username);
    }

    @Override
    public void create(AccountCreateForm form){
        String password = passwordEncoder.encode(form.getPassword());
        Account account = mapper.map(form,Account.class);
        account.setPassword(password);
        repository.save(account);
    }

    @Override
    public void update(AccountUpdateForm form){
        String password = passwordEncoder.encode(form.getPassword());
        Account account = mapper.map(form,Account.class);
        account.setPassword(password);
        repository.save(account);
    }

    @Override
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
    @Override
    public void deleteAll(List<Integer> ids){
        repository.deleteAllById(ids);
    }

    @Transactional
    @Override
    public UserDetails loadUserById(Integer userId) {
        Account account = repository.findById(userId).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + userId)
        );

        return new CustomAccountDetail(account);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = repository.findByUsername(username);
        if (username == null){
            throw new UsernameNotFoundException(username);
        }
        return new CustomAccountDetail(account);
    }



}
