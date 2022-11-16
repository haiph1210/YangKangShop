package com.YangKang.validation;

import com.YangKang.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryExistsByNameValidator implements ConstraintValidator<CategoryExistsByName,String> {
    @Autowired
    private ICategoryRepository repository;
    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return repository.existsByName(name);
    }
}
