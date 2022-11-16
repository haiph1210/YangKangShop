package com.vti.slide08.validation;

import com.vti.slide08.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DepartmentIdExsitsValidator implements ConstraintValidator<DepartmentIdExists,Integer> {
    @Autowired
    private IDepartmentRepository repository;


    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext context) {

        return repository.existsById(id);
    }
}
