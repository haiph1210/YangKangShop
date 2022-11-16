package com.YangKang.repository;

import com.YangKang.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IAccountRepository extends JpaRepository<Account,Integer>, JpaSpecificationExecutor<Account> {
    Account findByUsername(String username);
    boolean existsByUsername(String username);
}