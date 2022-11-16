package com.vti.service;

import com.vti.entity.Department;
import com.vti.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Service
@Transactional  // nếu bên repo có del or update thì phải có
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentRepository repository;

    @Override
    public Page<Department> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    @Override
    public Department findByID( Integer id){

        return repository.findById(id).orElse(null);
    }

    @Override
    public void createDepartment(Department department){
        repository.save(department);
    }

    @Override
    public void updateDepartment(Department department){
        repository.save(department);
    }

    @Override
    public void deleteByID(Integer id){
        repository.deleteById(id);
    }

    @Override
    public Department findByName(String name) {
        return repository.findByName(name);
    }
//
//    @Override
//    public List<Department> findByNameAndTotalMembersGreaterThanEqual(String name, Integer totalMembers) {
//        return null;
//    }

    @Override
    public void deleteByName(String name) {
        repository.deleteByName(name);
    }


}
