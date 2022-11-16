package com.vti.service;

import com.vti.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDepartmentService {
    Page<Department> findAll(Pageable pageable);

    Department findByID(Integer id);

    void createDepartment(Department department);

    void updateDepartment(Department department);

    void deleteByID(Integer id);

    Department findByName(String name);
//    List<Department> findByNameAndTotalMembersGreaterThanEqual(String name,Integer totalMembers);
    void deleteByName(String name);
}
