package com.vti.slide08.service;

import com.vti.slide08.entity.Account;
import com.vti.slide08.form.AccountCreateForm;
import com.vti.slide08.form.AccountFIlterForm;
import com.vti.slide08.form.AccountUpdateForm;
import com.vti.slide08.repository.IAccountRepository;
import com.vti.slide08.specification.AccountSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder ;

    @Override
    public Page<Account> findAll(Pageable pageable, AccountFIlterForm form){
        Specification<Account> spec = AccountSpecification.buildWhere(form);
        return repository.findAll(spec,pageable);
    }
    @Override
    public Account findById(Integer id){

        return repository.findById(id).orElse(null);
    }
    @Override
    public Account findByUsername(String name){
        return repository.findByUsername(name);
    }
    @Override
    public void create(AccountCreateForm form){
        String encodedPassword = passwordEncoder.encode(form.getPassword());
        Account account = mapper.map(form,Account.class);
        account.setPassword(encodedPassword);
        repository.save(account);
    }
    @Override
    public void update(AccountUpdateForm form){
        String encodedPassword = passwordEncoder.encode(form.getPassword());
        Account account = mapper.map(form,Account.class);
        account.setPassword(encodedPassword);
        repository.save(account);
    }
    @Override
    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    // Sercurity  đăng nhập
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = repository.findByUsername(username);
        if (account == null){
            throw new UsernameNotFoundException(username);
        }
            return new User(
                    account.getUsername(), //
                    account.getPassword(),
//                    Collections.emptyList()  ko quyền
                    AuthorityUtils.createAuthorityList(account.getRole().toString())
            );
    }
}
