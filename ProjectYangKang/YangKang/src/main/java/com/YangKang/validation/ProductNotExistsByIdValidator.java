package com.YangKang.validation;

import com.YangKang.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductNotExistsByIdValidator implements ConstraintValidator<ProductNotExistsById,Integer> {
    @Autowired
    private IProductRepository repository ;
    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext constraintValidatorContext) {
        return !repository.existsById(id);
    }
}
