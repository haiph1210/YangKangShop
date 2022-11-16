package com.vti.slide08.service;

import com.vti.slide08.entity.Account;
import com.vti.slide08.entity.Department;
import com.vti.slide08.form.DepartmentCreateForm;
import com.vti.slide08.form.DepartmentFilterForm;
import com.vti.slide08.form.DepartmentUpdateForm;
import com.vti.slide08.repository.IAccountRepository;
import com.vti.slide08.repository.IDepartmentRepository;
import com.vti.slide08.specification.DepartmentSpecification;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentRepository repository;
    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Page<Department> findAll(Pageable pageable, DepartmentFilterForm form){
        Specification<Department> specification = DepartmentSpecification.buildWhere(form);
        return repository.findAll(specification,pageable);
    }
    @Override
    public Department findById(Integer id){
        return repository.findById(id).orElse(null);
    }
    @Override
    public Department findByName(String name){
        return repository.findByName(name);
    }
    @Override
    @Transactional  // tạo ko thành c
    public void create(DepartmentCreateForm form){
        Department department = mapper.map(form, Department.class);
        List<Account> accounts = department.getAccounts();
        if (accounts != null) {
            for (Account account : accounts) {
                account.setDepartment(department);
                account.setPassword();
            }
        }
        repository.save(department);
        accountRepository.saveAll(accounts);
//        List<Account> accounts = mapper.map(form.getAccounts(),new TypeToken<List<Account>>(){}.getType());
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
