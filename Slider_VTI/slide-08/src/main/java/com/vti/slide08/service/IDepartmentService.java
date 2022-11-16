package com.vti.slide08.service;

import com.vti.slide08.entity.Department;
import com.vti.slide08.form.DepartmentCreateForm;
import com.vti.slide08.form.DepartmentFilterForm;
import com.vti.slide08.form.DepartmentUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDepartmentService {
    Page<Department> findAll(Pageable pageable, DepartmentFilterForm form);

    Department findById(Integer id);

    Department findByName(String name);

    void create(DepartmentCreateForm form);

    void update(DepartmentUpdateForm form);

    void deleteById(Integer id);
}
