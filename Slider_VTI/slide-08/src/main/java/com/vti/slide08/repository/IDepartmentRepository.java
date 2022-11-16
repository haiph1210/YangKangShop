package com.vti.slide08.repository;

import com.vti.slide08.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IDepartmentRepository extends JpaRepository<Department,Integer> , JpaSpecificationExecutor {
    Department findByName(String name);
    boolean existsByName(String name);
}
