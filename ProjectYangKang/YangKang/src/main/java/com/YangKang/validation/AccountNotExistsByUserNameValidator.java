package com.YangKang.validation;

import com.YangKang.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AccountNotExistsByUserNameValidator implements ConstraintValidator<AccountNotExistsByUserName,String>  {
    @Autowired
    private IAccountRepository repository;
    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        return !repository.existsByUsername(username);
    }
}
