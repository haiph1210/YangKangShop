package com.vti.controller;

import com.vti.entity.Department;
import com.vti.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    @Autowired
    private IDepartmentService service;

    @GetMapping
    public Page<Department> findAll(Pageable pageable){
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Department findByID(@PathVariable Integer id){
        return service.findByID(id);
    }
    @PostMapping
    public void createDepartment(@RequestBody Department department){
        service.createDepartment(department);
    }

    @PutMapping("/{id}")
    public void updateDepartment(@PathVariable Integer id,@RequestBody Department department){
        department.setId(id);
        service.updateDepartment(department);
    }
    @DeleteMapping("/{id}")
    public void deleteByID(@PathVariable Integer id){
        service.deleteByID(id);
    }
    @GetMapping("/name/{name}")
    public Department findByName(@PathVariable String name){
        return service.findByName( name);
    }
    @DeleteMapping("/name/{name}")
    public void deleteByName(@PathVariable String name) {
        service.deleteByName(name);
    }
}
