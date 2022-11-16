package com.YangKang.validation;

import com.YangKang.entity.Account;
import com.YangKang.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AccountExistByNameValidator implements ConstraintValidator<AccountExistByUserName,String> {
    @Autowired
    private IAccountRepository repository;
    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return repository.existsByUsername(username);
    }
}
