package com.YangKang.validation;

import com.YangKang.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductExistsByNameValidator implements ConstraintValidator<ProductExistsByName,String> {
    @Autowired
    private IProductRepository repository ;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return repository.existsByName(name);
    }
}
