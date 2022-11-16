package com.vti.slide08.validation;

import com.sun.org.apache.xerces.internal.impl.dtd.models.ContentModelValidator;
import com.vti.slide08.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DepartmentNameNotExistsValidator implements ConstraintValidator<DepartmentNameNotExists,String> {
    @Autowired
    private IDepartmentRepository repository;
    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return !repository.existsByName(name);
    }
}
