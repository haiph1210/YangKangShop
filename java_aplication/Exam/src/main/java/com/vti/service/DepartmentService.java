package com.vti.service;

import com.vti.entity.Department;
import com.vti.form.DepartmentCreateForm;
import com.vti.form.DepartmentFilterForm;
import com.vti.form.DepartmentUpdateForm;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IDepartmentRepository;
import com.vti.specsification.DepartmentSpecification;

import lombok.ToString;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@ToString
public class DepartmentService implements IDepartmentService {
    @Autowired
    IDepartmentRepository departmentRepository;

    @Autowired
    IAccountRepository accountRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private PasswordEncoder passwordEncoder ;
//    @Autowired
//    private Session session = null;
    @Override
    public Page<Department> findAll(Pageable pageable, DepartmentFilterForm form) {
        Specification<Department> specification = DepartmentSpecification.buildWhere(form);
        return departmentRepository.findAll(specification,pageable);
    }

    @Override
    public Department findById(Integer id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public Department findByName(String name) {
        return departmentRepository.findByName(name);
    }

//    @SneakyThrows
//    @Override
//    @Transactional
//    public void create(DepartmentCreateForm form) {
//        // TODO neu nguoi ta muon truyen vao account da co san trong He thong thi sao??
//        Department department = mapper.map(form, Department.class);
//        List<Account> accounts = department.getAccounts();
//        if (accounts == null || accounts.isEmpty()) {
//            // neu k co acc nao, thi se return luon
//            throw new Exception("Phong ban nay dang khong co account nao!");
//        }
//        for (Account account : accounts) {
//            account.setDepartment(department);
//        }
//
//
//        departmentRepository.save(department);
//        accountRepository.saveAll(accounts);
//
//        Integer idMax = accounts.size();
//        System.out.println(idMax);
//        department.setTotalMembers(Double.valueOf(idMax));
//
//
//
//    }

    @Override
    @Transactional  // tạo ko thành c
    public void create(DepartmentCreateForm form) {
        Department department = mapper.map(form, Department.class);
//        int countId = accountRepository.countAccountId();
//       department.setTotalMembers(countId);
//        System.out.println("countId = " + countId);

//        SQLQuery query = session.createSQLQuery("SELECT COUNT(id) FROM Account ");
//        query.addEntity(Account.class);
//
//        System.out.println("query = " + query);
//        List<Account> accounts = department.getAccounts();
//        if (accounts != null) {
//            for (Account account : accounts) {
//                String passwordEncoded = passwordEncoder.encode(account.getPassword());
//                account.setDepartment(department);
//                account.setPassword(passwordEncoded);
//            }
//        }
        departmentRepository.save(department);
//        accountRepository.saveAll(accounts);
    }


    @Override
    public void update(DepartmentUpdateForm form) {
        Department department = mapper.map(form, Department.class);
        departmentRepository.save(department);
    }

    @Override
    public void deleteById(Integer id) {
        departmentRepository.deleteById(id);
    }
    @Override
    public void deleteAll(List<Integer> ids) {
        departmentRepository.deleteAllById(ids);
    }
}
