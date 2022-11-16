package com.YangKang.validation;

import com.YangKang.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryNotExistsByIdValidator implements ConstraintValidator<CategoryNotExistsById,Integer> {
    @Autowired
    private ICategoryRepository repository;
    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {
        return !repository.existsById(id);
    }
}