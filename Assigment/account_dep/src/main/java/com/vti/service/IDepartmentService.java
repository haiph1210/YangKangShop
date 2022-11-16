package com.vti.service;

import com.vti.entity.Department;
import com.vti.form.DepartmentCreateForm;
import com.vti.form.DepartmentUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDepartmentService {
    Page<Department> findAll(Pageable pageable);

    Department findById(Integer id);

    void create(DepartmentCreateForm form);

    void update(DepartmentUpdateForm form);

    void deleteById(Integer id);
}
