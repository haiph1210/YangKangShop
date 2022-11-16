package com.vti.service;

import com.vti.entity.Student;
import com.vti.form.StudentCreateForm;
import com.vti.form.StudentUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService {
    Page<Student> findAll(Pageable pageable);

    Student findById(Integer id);

    Student findByEmail(String email);

    void create(StudentCreateForm form);

    void update(StudentUpdateForm form);

    void deleteById(Integer id);
}
