package com.vti.slide08.repository;

import com.vti.slide08.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IAccountRepository extends JpaRepository<Account,Integer> , JpaSpecificationExecutor<Account> {
    Account findByUsername(String name);

}
