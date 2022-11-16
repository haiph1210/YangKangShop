package com.vti.repository;

import com.vti.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student,Integer> {
    Student findByEmail(String email);
}
