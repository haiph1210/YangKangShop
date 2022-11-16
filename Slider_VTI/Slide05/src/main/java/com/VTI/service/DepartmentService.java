package com.VTI.service;

import com.VTI.entity.Department;
import com.VTI.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {
    @Autowired // tự động tạo mới
    @Qualifier("com.VTI.repository.DepartmentRepository")
    private IDepartmentRepository repository;


    @Override
    public List<Department> getAll() {
        return repository.getAll();
    }

    @Override
    public Department getById(int id) {
        return repository.getById(id);
    }

    @Override
    public Department getByName(String name) {
        return repository.getByName(name);
    }

    @Override
    public void create(Department department) {
        repository.create(department);
    }

    @Override
    public void update(Department department) {
        repository.update(department);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(int id) {
        return repository.existsById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return repository.existsByName(name);
    }
}
