package com.vti.service;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.form.AccountCreateForm;
import com.vti.form.AccountUpdateForm;
import com.vti.form.DepartmentCreateForm;
import com.vti.form.DepartmentUpdateForm;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IDepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentRepository repository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<Department> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }
    @Override
    public Department findById(Integer id){
        return repository.findById(id).orElse(null);
    }
    @Override
    @Transactional
    public void create(DepartmentCreateForm form){
        Department department = mapper.map(form, Department.class);
        List<Account> accounts = department.getAccounts();
        if (accounts != null) {
            for (Account account : accounts) {
                account.setDepartment(department);
            }
        }
        repository.save(department);
    }
    @Override
    public void update(DepartmentUpdateForm form){
        Department department = mapper.map(form,Department.class);
        repository.save(department);
    }
    @Override
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}
