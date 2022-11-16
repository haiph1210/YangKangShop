package com.vti.repository;

import com.vti.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IAccountRepository extends JpaRepository<Account,Integer> {
    Account findByEmail(String email);
//    @Query("From Account Where name = ?1")
//    @Modifying
//    Account findByName(String name);

}
