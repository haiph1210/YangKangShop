package com.VTI.repository;

import com.VTI.entity.Department;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("com.VTI.repository.DepartmentRepositoryV1")

public class DepartmentRepositoryV1 implements IDepartmentRepository{

    @Override
    public List<Department> getAll() {
        return null;
    }

    @Override
    public Department getById(int id) {
        return null;
    }

    @Override
    public Department getByName(String name) {
        return null;
    }

    @Override
    public void create(Department department) {

    }

    @Override
    public void update(Department department) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public boolean existsById(int id) {
        return false;
    }

    @Override
    public boolean existsByName(String name) {
        return false;
    }
}
