package com.vti.repository;

import com.vti.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDepartmentRepository extends JpaRepository<Department,Integer> {
    @Query("From Department Where name = ?1")
    Department findByName(String name);
    List<Department> findByNameAndTotalMembersGreaterThanEqual(String name,Integer totalMembers);
    @Query("Delete From Department Where name = ?1")
    @Modifying // nếu bên repo có del or update thì phải có
    void deleteByName(String name);
}
